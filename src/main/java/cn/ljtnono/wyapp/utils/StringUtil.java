package cn.ljtnono.wyapp.utils;

/**
 *  字符串操作的一些封装
 *  @author ljt
 *  @date 2019/5/29
 *  @version 1.0
*/
public class StringUtil {

    private StringUtil(){}

    /**
     * 检测字符串是否为空
     * @param val 要检测的字符串
     * @return true 为空 false 不为空
     */
    public static boolean isEmpty(String val) {
        return val == null || val.length() == 0;
    }


    /**
     * 删除字符串中的空格和换行
     * @param val 需要删除的字符串
     * @return 删除空格和换行后的字符串
     */
    public static String deleteBlank(String val) {
        String result = val;
        if (val.isEmpty()) {
            throw new IllegalArgumentException("不能删除空字符串！");
        } else {
            // 删除字符串前后的空格
            result = result.trim();
            // 去掉所有的
            result = result.replaceAll("\\s", "");
            return result;
        }
    }

    /**
     * 对字符串进行加密
     * @param val 需要加密的字符串
     * @param type 加密类型
     * @return 加密后的字符串
     */
    public static String encrypt(String val, String type) {
//        String result;
//        if ("md5".equals(deleteBlank(type.toLowerCase()))) {
//            result = EncryptUtil.getMD5(val);
//        } else if ("".equals(deleteBlank(type.toLowerCase()))){
//
//        }
        // TODO 加密
        return null;
    }

}
