package cn.ljtnono.wyapp.util;

import cn.ljtnono.wyapp.utils.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringUtilTest {

    @Test
    public void testValidateTel() {
        System.out.println(StringUtil.validateTel("1533710675")); //false
        System.out.println(StringUtil.validateTel("15337106753")); //true
    }
}
