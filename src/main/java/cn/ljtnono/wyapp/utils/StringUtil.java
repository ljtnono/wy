package cn.ljtnono.wyapp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.regex.Pattern;

/**
 *  字符串操作的一些封装
 *  @author ljt
 *  @date 2019/5/29
 *  @version 1.0
*/
public class StringUtil {

    private final static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    private StringUtil(){}

    /**
     * 验证手机号码的 Pattern对象
     */
    private static final Pattern TEL_REGEX = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");

    /**
     * 检测字符串是否为空
     * @param val 要检测的字符串
     * @return true 为空 false 不为空
     */
    public static boolean isEmpty(final String val) {
        return val == null || val.length() == 0;
    }


    /**
     * 删除字符串中的空格和换行
     * @param val 需要删除的字符串
     * @return 删除空格和换行后的字符串
     */
    public static String deleteBlank(final String val) {
        String result = val;
        if (!val.isEmpty()) {
            // 删除字符串前后的空格
            result = result.trim();
            // 去掉所有的
            result = result.replaceAll("\\s", "");
        }
        return result;
    }

    /**
     * 对字符串进行加密
     * @param val 需要加密的字符串
     * @param type 加密类型 MD5 表示进行MD5加密
     * @return 成功返回加密后的字符串 失败返回null
     */
    public static String encrypt(final String val, final String type) {
        if (type.equalsIgnoreCase("MD5")) {
            return encryptMD5(val);
        }
        return null;
    }

    /**
     * md5加密方式 32位
     * @param val 需要加密的字符串
     * @return 失败返回null 成功返回加密后的字符串
     */
    private static final String encryptMD5(final String val) {
        if (StringUtil.isEmpty(val)) {
            throw new IllegalArgumentException("参数不能为空！");
        }
        return EncryptUtil.getMD5(val);
    }

    /**
     * 验证一个字符串是否为手机的格式
     * @param tel 需要验证的字符串
     * @return 验证成功返回true  验证失败或者tel参数为空返回false
     */
    public static boolean validateTel(final String tel) {
        if (isEmpty(tel)) {
            return false;
        }
        return TEL_REGEX.matcher(tel).matches();
    }

    /**
     * 根据regex正则表达式验证一个字符串格式
     * @param arg 需要验证的代码
     * @param pattern 正则表达式
     * @return 符合格式返回true 不符合格式返回false
     */
    public static boolean validateStringByRegex(final String arg, final Pattern pattern) {
        if (isEmpty(arg)) {
            return false;
        }
        if (pattern == null) {
            throw new NullPointerException("正则表达式不能为null!");
        }
        return pattern.matcher(arg).matches();
    }


}
