package cn.ljtnono.wyapp.util;

import cn.ljtnono.wyapp.utils.UserUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserUtilTest {
    
    @Test
    public void testGetRadomUserId() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(UserUtil.getRadomUserId());
        }
    }


}
