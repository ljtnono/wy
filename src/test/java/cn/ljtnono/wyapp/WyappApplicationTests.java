package cn.ljtnono.wyapp;

import cn.ljtnono.wyapp.dao.WyUserDao;
import cn.ljtnono.wyapp.entity.WyUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WyappApplicationTests {

    @Autowired
    private WyUserDao wyUserDao;

    @Test
    public void contextLoads() {
        WyUser wyUser = wyUserDao.selectByPrimaryKey("1");
        System.out.println(wyUser);
    }

}
