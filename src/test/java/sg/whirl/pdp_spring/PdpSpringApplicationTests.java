package sg.whirl.pdp_spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import sg.whirl.pdp_spring.configurations.AppConfig;
import sg.whirl.pdp_spring.configurations.Prefixed;
import sg.whirl.pdp_spring.main.PdpSpringApplication;

@RunWith( SpringRunner.class )
@SpringBootTest(classes = PdpSpringApplication.class, properties = {"directIntProp=5"})
@ActiveProfiles("another")
@ContextConfiguration
@TestPropertySource("classpath:additional.properties")
public class PdpSpringApplicationTests {

    @Autowired
    AppConfig appConfig;

    @Autowired
    Prefixed prefixed;

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

}
