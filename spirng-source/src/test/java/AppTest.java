import com.learn.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: AppTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Mitsuha
 * @Create 2024/12/4 20:16
 * @Version 1.0
 */
public class AppTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService service = (UserService) context.getBean("service");
        service.sayHello();

    }
}
