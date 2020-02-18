package sg.whirl.pdp_spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "sg.whirl.pdp_spring")
public class PdpSpringApplication {
    public static void main( String[] args ) {
        SpringApplication.run( PdpSpringApplication.class, args );
    }
}
