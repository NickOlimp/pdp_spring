package sg.whirl.pdp_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import sg.whirl.pdp_spring.beans.ConstructorAutowiredBean;
import sg.whirl.pdp_spring.beans.FieldAutowiredBean;
import sg.whirl.pdp_spring.beans.SetterAutowiredBean;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Service
public class PdpSpringApplication {

    @Autowired
    private FieldAutowiredBean fieldAutowiredBean;

    private SetterAutowiredBean setterAutowiredBean;

    private final ConstructorAutowiredBean constructorAutowiredBean;

    @Autowired
    public void setSetterAutowiredBean(SetterAutowiredBean bean) {
        this.setterAutowiredBean = bean;
    }

    public PdpSpringApplication(ConstructorAutowiredBean bean) {
        this.constructorAutowiredBean = bean;
    }

    @PostConstruct
    void initialized() {
        System.out.println();

        System.out.println("fieldAutowiredBean " + ( fieldAutowiredBean == null ? "NOT " : "") + "initialized.");
        System.out.println("setterAutowiredBean " + ( setterAutowiredBean == null ? "NOT " : "") + "initialized.");
        System.out.println("constructorAutowiredBean " + ( constructorAutowiredBean == null ? "NOT " : "") + "initialized.");

        System.out.println();
    }

    public static void main( String[] args ) {
        SpringApplication.run( PdpSpringApplication.class, args );

    }

}
