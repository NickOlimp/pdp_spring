package sg.whirl.pdp_spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import sg.whirl.pdp_spring.main.PdpSpringApplication;

@RunWith( SpringRunner.class )
@SpringBootTest(classes = PdpSpringApplication.class)
@ActiveProfiles("dev")
public class PdpSpringApplicationTests {

    @Test
    public void contextLoads() {
    }

}
