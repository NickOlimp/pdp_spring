package sg.whirl.pdp_spring.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sg.whirl.pdp_spring.interfaces.BeanInterface;

@Component("bean2")
@Qualifier("selectedBeans")
public class BeanImpl2 implements BeanInterface {
}
