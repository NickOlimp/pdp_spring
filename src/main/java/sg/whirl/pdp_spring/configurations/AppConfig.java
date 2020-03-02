package sg.whirl.pdp_spring.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import sg.whirl.pdp_spring.beans.*;

import javax.annotation.PostConstruct;
import java.util.*;

@Configuration
public class AppConfig {

    @Autowired
    public Environment env;

    @Value("${test.value:defaultValue}")
    public String testValue;

    public String envValue;

    @Value("${test.nonexistentValue:defaultValue}")
    public String defaultValue;


    @Value("${test.profileProp}")
    public String profileValue;

    @Value("${directIntProp:1}")
    public int directPropIntValue;

    @PostConstruct
    public void init() {
        this.envValue = env.getProperty("test.envValue");
    }

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
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        return map;
    }

    @Bean
    public BeanImpl1 bean1A() {
        return new BeanImpl1A();
    }

    @Bean
    public BeanImpl1 bean1B() {
        return new BeanImpl1B();
    }

    @Bean(name = "item")
    public ItemFactory itemFactory() {
        return new ItemFactory();
    }

    @Bean
    public Item item1() {
        return itemFactory().getObject();
    }

    @Bean
    public Item item2() {
        return itemFactory().getObject();
    }
}
