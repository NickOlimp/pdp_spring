package sg.whirl.pdp_spring.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "prefixed")
@Data
public class Prefixed {
    String field1;
    String field2;
}
