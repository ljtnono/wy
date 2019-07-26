package cn.ljtnono.wyapp.utils;

import java.util.UUID;

/**
 * 用户工具类
 *  @author 凌家童
 *  @date 2019/7/21
 *  @version 1.0
 *
*/
public class UserUtil {

    private static char[] args = {
            'a','b','c','d','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            '1','2','3','4','5','6','7','8','9','0'
    };
    private UserUtil(){}

    /**
     * 获取随机用户名
     * @return 随机用户名
     */
    public static String getRadomUserId() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            s.append(args[(int) (Math.random() * (args.length - 1))]);
        }
        return s.toString();
    }

    public static String getRadomLoginName() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            s.append(args[(int) (Math.random() * (args.length - 1))]);
        }
        return s.toString();
    }

}
