package sg.whirl.pdp_spring;

import lombok.NonNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import sg.whirl.pdp_spring.annotations.CorrectQualifier;
import sg.whirl.pdp_spring.beans.*;
import sg.whirl.pdp_spring.configurations.AppConfig;
import sg.whirl.pdp_spring.configurations.Prefixed;
import sg.whirl.pdp_spring.interfaces.BeanInterface;
import sg.whirl.pdp_spring.main.PdpSpringApplication;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PdpSpringApplication.class, properties = {"directIntProp=5"})
@ActiveProfiles({"another", "dev"})
@ContextConfiguration
@TestPropertySource("classpath:additional.properties")
public class PdpSpringApplicationTests {

    @Autowired
    AppConfig appConfig;

    @Autowired
    Prefixed prefixed;

    @Autowired
    private FieldAutowiredBean fieldAutowiredBean;

    private SetterAutowiredBean setterAutowiredBean;

    @Autowired
    private ConstructorBean constructorBean;

    @Autowired
    @Qualifier("namedBean")
    private Object namedBean;

    @Autowired(required = false)
    private NonDeclaredBean nonexistentBean;

    @Autowired
    @Qualifier("bean2")
    private BeanInterface qualifiedBean;

    @Autowired
    private BeanInterface primaryBean;

    @Autowired
    private List<BeanInterface> beanList;

    @Autowired
    private List<Integer> integerList;

    @Autowired
    private Set<Integer> integerSet;

    @Autowired
    private Map<String, Integer> stringIntegerMap;

    @Autowired(required = false)
    private List<NonDeclaredBean> emptyList = new ArrayList<>();

    @Autowired
    @Qualifier("selectedBeans")
    private List<BeanInterface> selectedBeanList;

    @Autowired
    @CorrectQualifier
    private List<BeanInterface> correctBeanList;

    @Autowired
    private List<BeanImpl1> typeLimitedBeanList;

    @Autowired
    private Item item1;

    @Autowired
    private Item item2;

    @Resource(name = "&item")
    private ItemFactory itemFactory;

    @Autowired(required = false)
    private DevProfileBean devProfileBean;

    @Autowired
    public void setSetterAutowiredBean(SetterAutowiredBean bean) {
        this.setterAutowiredBean = bean;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testPropertyValue() {
        Assert.assertEquals("additionalValue", appConfig.testValue);
    }

    @Test
    public void testEnvPropertyValue() {
        Assert.assertEquals("envValue", appConfig.envValue);
    }

    @Test
    public void testDefaultPropertyValue() {
        Assert.assertEquals("defaultValue", appConfig.defaultValue);
    }

    @Test
    public void testProfilePropertyValue() {
        Assert.assertEquals("anotherValue", appConfig.profileValue);
    }

    @Test
    public void testDirectPropertyValue() {
        Assert.assertEquals(5, appConfig.directPropIntValue);
    }

    @Test
    public void testPrefixedPropertyValue() {
        Assert.assertEquals("prefValue1", prefixed.getField1());
        Assert.assertEquals("prefValue2", prefixed.getField2());
    }

    @Test
    public void testFieldAutowiredBean() {
        Assert.assertNotNull(fieldAutowiredBean);
    }

    @Test
    public void testSetterAutowiredBean() {
        Assert.assertNotNull(setterAutowiredBean);
    }

    @Test
    public void testConstructorAutowiredBean() {
        Assert.assertNotNull(constructorBean.constructorAutowiredBean1);
    }

    @Test
    public void testConstructorDefaultValue() {
        Assert.assertEquals("defaultValue", constructorBean.requiredString);
    }

    @Test
    public void testNamedBean() {
        Assert.assertNotNull(namedBean);
        Assert.assertEquals(DefaultBean.class, namedBean.getClass());
    }

    @Test
    public void testNotRequiredBean() {
        Assert.assertNull(nonexistentBean);
    }

    @Test
    public void testQualifiedBean() {
        Assert.assertNotNull(namedBean);
        Assert.assertEquals(BeanImpl2.class, qualifiedBean.getClass());
    }

    @Test
    public void testPrimaryBean() {
        Assert.assertNotNull(primaryBean);
        Assert.assertEquals(BeanImpl3.class, primaryBean.getClass());
    }

    private <E> boolean listContainsClass(@NonNull List<E> list, @NonNull Class cl) {
        return list.stream()
                .map(Object::getClass)
                .anyMatch(cl::equals);
    }

    // TODO rewrite to check that ONLY the given classes are present
    private <E> boolean listContainsClasses(@NonNull List<E> list, @NonNull Class... cls) {
        return Arrays.stream(cls)
                .allMatch(cl -> listContainsClass(list, cl));
    }

    @Test
    public void testAutowiredBeanList() {
        Assert.assertNotNull(beanList);
        Assert.assertTrue(listContainsClasses(
                beanList,
                BeanImpl1.class,
                BeanImpl1A.class,
                BeanImpl1B.class,
                BeanImpl2.class,
                BeanImpl3.class
        ));
    }

    @Test
    public void testIntegerListBean() {
        Assert.assertNotNull(integerList);
        Assert.assertEquals(Arrays.asList(1, 2, 3), integerList);
    }

    @Test
    public void testIntegerSetBean() {
        Assert.assertNotNull(integerSet);
        Assert.assertEquals(new HashSet(Arrays.asList(4, 5, 6)), integerSet);

    }

    @Test
    public void testStringIntegerMapBean() {
        Assert.assertNotNull(stringIntegerMap);
        Assert.assertEquals(3, stringIntegerMap.size());
        Assert.assertEquals(new Integer(1), stringIntegerMap.get("1"));
        Assert.assertEquals(new Integer(2), stringIntegerMap.get("2"));
        Assert.assertEquals(new Integer(3), stringIntegerMap.get("3"));
    }

    @Test
    public void testEmptyListBean() {
        Assert.assertNotNull(emptyList);
        Assert.assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testQualifiedBeanList() {
        Assert.assertNotNull(selectedBeanList);
        Assert.assertTrue(listContainsClasses(
                selectedBeanList,
                BeanImpl2.class
        ));
    }

    @Test
    public void testCustomQualifiedBeanList() {
        Assert.assertNotNull(correctBeanList);
        Assert.assertTrue(listContainsClasses(
                correctBeanList,
                BeanImpl1.class
        ));
    }

    @Test
    public void testTypeLimitedBeanList() {
        Assert.assertNotNull(typeLimitedBeanList);
        Assert.assertTrue(listContainsClasses(
                typeLimitedBeanList,
                BeanImpl1.class,
                BeanImpl1A.class,
                BeanImpl1B.class
        ));
    }

    @Test
    public void testFactoryCreatedBeans() {
        Assert.assertNotNull(item1);
        Assert.assertNotNull(item2);
        Assert.assertEquals(1, item1.getId());
        Assert.assertEquals(2, item2.getId());
    }

    @Test
    public void testBeanFactory() {
        Assert.assertNotNull(itemFactory);
        Assert.assertEquals(ItemFactory.class, itemFactory.getClass());
    }

    @Test
    public void testProfileBean() {
        Assert.assertNotNull(devProfileBean);
        Assert.assertEquals(DevProfileBean.class, devProfileBean.getClass());
    }

}
