package sg.whirl.pdp_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import sg.whirl.pdp_spring.beans.AutowiredBean;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Service
public class PdpSpringApplication {

    @Autowired
    private AutowiredBean fieldAutowiredBean;

    @PostConstruct
    void initialized() {
        if (fieldAutowiredBean != null) {
            System.out.println("fieldAutowiredBean initialized.");
        }
    }

    public static void main( String[] args ) {
        SpringApplication.run( PdpSpringApplication.class, args );

    }

}
