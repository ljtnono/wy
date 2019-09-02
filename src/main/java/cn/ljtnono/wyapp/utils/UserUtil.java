package cn.ljtnono.wyapp.utils;

import java.util.regex.Pattern;

import static cn.ljtnono.wyapp.utils.StringUtil.validateStringByRegex;

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
    /**
     * 用户名检测正则表达式
     * 4-10位字符数字组合
     */
    private static Pattern LOGIN_NAME_REGEX = Pattern.compile("^[a-zA-Z0-9_-]{4,10}$");
    /**
     * 密码检测正则表达式
     * 密码是6-18位字母和数字的组合 .+*-_/
     */
    private static Pattern PASSWORD_REGEX = Pattern.compile("^[a-zA-Z0-9-\\_\\.\\+\\*\\/]{6,18}$");
    private UserUtil(){}

    /**
     * 获取随机用户Id
     * @return 随机用户Id
     */
    public static String getRadomUserId() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            s.append(args[(int) (Math.random() * (args.length - 1))]);
        }
        return s.toString();
    }

    /**
     * 检查用户名是否符合格式
     * @param loginName 需要检查的用户名
     * @return 符合格式返回true  不符合格式返回false
     *  TODO 需要进行测试
     */

    public static boolean validateLoginName(final String loginName) {
        return validateStringByRegex(loginName, LOGIN_NAME_REGEX);
    }

    /**
     * 检查密码是否符合格式
     * @param password 需要检查的密码
     * @return 符合格式返回true 不符合格式返回false
     * TODO 需要进行测试
     */
    public static boolean validatePassword(final String password) {
        return validateStringByRegex(password, PASSWORD_REGEX);
    }
}
