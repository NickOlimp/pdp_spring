package sg.whirl.pdp_spring.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sg.whirl.pdp_spring.interfaces.BeanInterface;

@Component
@Primary
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BeanImpl3 implements BeanInterface {
}
