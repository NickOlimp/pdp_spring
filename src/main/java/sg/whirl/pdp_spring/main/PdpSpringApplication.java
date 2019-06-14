package sg.whirl.pdp_spring.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import sg.whirl.pdp_spring.annotations.CorrectQualifier;
import sg.whirl.pdp_spring.beans.ConstructorAutowiredBean;
import sg.whirl.pdp_spring.beans.FieldAutowiredBean;
import sg.whirl.pdp_spring.beans.NonDeclaredBean;
import sg.whirl.pdp_spring.beans.SetterAutowiredBean;
import sg.whirl.pdp_spring.interfaces.BeanInterface;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
@ComponentScan(basePackages = "sg.whirl.pdp_spring")
public class PdpSpringApplication {

    @Autowired
    private FieldAutowiredBean fieldAutowiredBean;

    private SetterAutowiredBean setterAutowiredBean;

    private final ConstructorAutowiredBean constructorAutowiredBean;

    private final Object namedBean;

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
    public void setSetterAutowiredBean(SetterAutowiredBean bean) {
        this.setterAutowiredBean = bean;
    }

    public PdpSpringApplication(ConstructorAutowiredBean bean, @Qualifier("namedBean") Object namedBean) {
        this.constructorAutowiredBean = bean;
        this.namedBean = namedBean;
    }

    @PostConstruct
    void initialized() {
        System.out.println();

        System.out.println("fieldAutowiredBean " + (fieldAutowiredBean == null ? "NOT " : "") + "initialized.");
        System.out.println("setterAutowiredBean " + (setterAutowiredBean == null ? "NOT " : "") + "initialized.");
        System.out.println("constructorAutowiredBean " + (constructorAutowiredBean == null ? "NOT " : "") + "initialized.");
        System.out.println("namedBean " + (namedBean == null ? "NOT " : "(" + namedBean.getClass().getSimpleName() + ") ") + "initialized.");
        System.out.println("nonexistentBean " + (nonexistentBean == null ? "NOT " : "") + "initialized.");
        System.out.println("qualifiedBean " + (qualifiedBean == null ? "NOT " : "(" + qualifiedBean.getClass().getSimpleName() + ") ") + "initialized.");
        System.out.println("primaryBean " + (primaryBean == null ? "NOT " : "(" + primaryBean.getClass().getSimpleName() + ") ") + "initialized.");
        System.out.println("beanList " + ( beanList == null ? "NOT " : "(" + beanList.stream()
                .map( Object::getClass )
                .map( Class::getSimpleName )
                .collect( Collectors.joining(","))
                + ") " ) + "initialized.");
        System.out.println("integerList " + (integerList == null ? "NOT " : "(" + integerList + ") ") + "initialized.");
        System.out.println("integerSet " + (integerSet == null ? "NOT " : "(" + integerSet + ") ") + "initialized.");
        System.out.println("stringIntegerMap " + (stringIntegerMap == null ? "NOT " : "(" + stringIntegerMap + ") ") + "initialized.");
        System.out.println("emptyList " + (emptyList == null ? "NOT " : "(" + emptyList + ") ") + "initialized.");
        System.out.println("selectedBeanList " + ( selectedBeanList == null ? "NOT " : "(" + selectedBeanList.stream()
                .map( Object::getClass )
                .map( Class::getSimpleName )
                .collect( Collectors.joining(","))
                + ") " ) + "initialized.");
        System.out.println("correctBeanList " + ( correctBeanList == null ? "NOT " : "(" + correctBeanList.stream()
                .map( Object::getClass )
                .map( Class::getSimpleName )
                .collect( Collectors.joining(","))
                + ") " ) + "initialized.");

        System.out.println();
    }

    public static void main( String[] args ) {
        SpringApplication.run( PdpSpringApplication.class, args );

    }

}
