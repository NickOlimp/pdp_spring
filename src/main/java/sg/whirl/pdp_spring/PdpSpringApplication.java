package sg.whirl.pdp_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sg.whirl.pdp_spring.beans.*;
import sg.whirl.pdp_spring.interfaces.BeanInterface;

import javax.annotation.PostConstruct;

@SpringBootApplication
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

        System.out.println();
    }

    public static void main( String[] args ) {
        SpringApplication.run( PdpSpringApplication.class, args );

    }

}
