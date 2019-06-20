import com.deepexi.user.StartupApplication;
import com.deepexi.user.domain.eo.User;
import com.deepexi.user.mapper.UserMapper;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration
@SpringBootTest(classes = StartupApplication.class)
@RunWith(SpringRunner.class)
public class test {
    @Autowired
    UserMapper userMapper;
    @Test
    public  void t(){
        userMapper.selectPageVo(1,1,1);

    }

    @Test
    public void insert(){
        User user = new User("李四",12,"122333","李四","lisi@email.com");
        user.setId("2332");
        System.out.println(userMapper.insert(user));
    }

    @Test
    public void del(){
      userMapper.deleteById("1");
    }

    @Test
    public void select(){
        User user = userMapper.selectById("2");
        System.out.println( user);
        System.out.println(user.getUserName());
    }

    @Test
    public void update(){
        User user = userMapper.selectById("2");
        user.setUserName("李四改过");
        userMapper.update(user);
        System.out.println( user);
        System.out.println(user.getUserName());
    }
}
