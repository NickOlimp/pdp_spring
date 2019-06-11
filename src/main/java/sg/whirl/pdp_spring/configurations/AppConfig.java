package sg.whirl.pdp_spring.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sg.whirl.pdp_spring.beans.DefaultBean;

@Configuration
public class AppConfig {

    @Bean
    public DefaultBean namedBean() {
        return new DefaultBean();
    }
}
