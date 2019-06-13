package sg.whirl.pdp_spring.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sg.whirl.pdp_spring.beans.DefaultBean;

import java.util.*;

@Configuration
public class AppConfig {

    @Bean(name = "namedBean")
    public DefaultBean namedBean() {
        return new DefaultBean();
    }

    @Bean
    public List<Integer> intList() {
        return Arrays.asList(1, 2, 3);
    }

    @Bean
    public Set<Integer> intSet() {
        return new HashSet(Arrays.asList(4, 5, 6));
    }

    @Bean
    public Map<String, Integer> strIntMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put( "1", 1 );
        map.put( "2", 2 );
        map.put( "3", 3 );
        return map;
    }
}
