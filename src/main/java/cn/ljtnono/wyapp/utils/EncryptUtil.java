package cn.ljtnono.wyapp.utils;

/**
 *  加密工具
 *  @author ljt
 *  @date 2019/5/29
 *  @version 1.0
*/
public class EncryptUtil {

    private EncryptUtil(){}

    /**
     *  对字符串进行MD5加密
     * @param source 需要加密的字符串
     * @return 密文
     */
    public static String getMD5(String source) {
        return getMD5(source.getBytes());
    }

    /**
     * 对字节数组进行加密
     * @param source 需要加密的字节数组
     * @return 密文
     */
    private static String getMD5(byte[] source) {
        String s = null;
        final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte tmp[];
            synchronized (EncryptUtil.class) {
                md.update(source);
                tmp = md.digest();
            }
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            // 换后的结果转换为字符串
            s = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 获取小写的MD5加密
     * @param source 需要加密的字符串
     * @return 加密后的密文
     */
    public static String getMD5LowerCase(String source) {
        return getMD5(source).toLowerCase();
    }

    /**
     * 获取大写的MD5加密
     * @param source 需要加密的字符串
     * @return 加密后的密文
     */
    public static String getMD5UpperCase(String source) {
        return getMD5(source).toUpperCase();
    }

    /**
     *  对字符串进行64位MD5加密
     * @param source 获取64位加密的字符串
     * @return 密文
     */
    public static String getMD5For64(String source) {

        return null;
    }

}
