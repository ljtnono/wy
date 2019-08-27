package cn.ljtnono.wyapp.util;

import cn.ljtnono.wyapp.utils.UserUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserUtilTest {

    /**
     * 测试生成随机id函数
     */
    @Test
    public void testGetRadomUserId() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(UserUtil.getRadomUserId());
        }
    }
    /**
     * 测试验证用户名函数
     */
    @Test
    public void testValidateLoginName() {
        // 测试用例
        String[] examples = {"", null, "1321321321321321321", "fdsafda", "aaa", "123", "afdaf12_", "f_--1+/*", "你是个屌丝", "0-1=", "fgafd**)^^@"};
        boolean[] results = new boolean[examples.length];
        boolean[] expects = {false, false, false, true, false, false, true, false, false, false, false};
        for (int i = 0; i < examples.length; i++) {
            results[i] = UserUtil.validateLoginName(examples[i]);
        }
        Assert.assertArrayEquals(expects, results);
    }

    /**
     * 测试验证密码函数
     */
    @Test
    public void testValidatePassword() {
        String[] examples = {"", null, "12321aa", "fdafdaf_==*", "fffff/*.-", "1256ffd/*-.", "=========","+++++++", "套你猴子！"};
        boolean[] results = new boolean[examples.length];
        boolean[] expects = {false, false, true, false, true, true, false, true, false};
        for (int i = 0; i < examples.length; i++) {
            results[i] = UserUtil.validatePassword(examples[i]);
        }
        Assert.assertArrayEquals(expects, results);
    }

}
