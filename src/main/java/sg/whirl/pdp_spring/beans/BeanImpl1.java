package sg.whirl.pdp_spring.beans;

import org.springframework.stereotype.Component;
import sg.whirl.pdp_spring.annotations.CorrectQualifier;
import sg.whirl.pdp_spring.interfaces.BeanInterface;

@Component("bean1")
@CorrectQualifier
public class BeanImpl1 implements BeanInterface {
}
