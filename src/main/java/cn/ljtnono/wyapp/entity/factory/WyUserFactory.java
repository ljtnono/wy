package cn.ljtnono.wyapp.entity.factory;

import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.utils.StringUtil;
import cn.ljtnono.wyapp.utils.UserUtil;

import java.util.Date;

/**
 * 用户类创建工厂
 *  @author 凌家童
 *  @date 2019/7/21
 *  @version 1.0
 *
*/
public class WyUserFactory implements WyFactory{

    public WyUserFactory() {}
    /**
     * 创建用户方法
     * @param args 创建时所需要的参数，具体看各个子类的要求
     *             第一个参数是String 类型 logName
     *             第二个参数是String 类型 password
     *             第三个参数是String 类型 tel
     *
     * @return WyUser实体
     * TODO 待单元测试
     */
    @Override
    public WyUser create(Object... args) {
        if (args == null || args.length < 3) {
            throw new IllegalArgumentException("请检查参数的格式！");
        }
        final String tel = (String) args[2];
        final String loginName = (String) args[0];
        final String password = (String) args[1];
        // 检查手机的正确性
        if (!StringUtil.validateTel(tel)) {
            throw new IllegalArgumentException("手机号码格式错误！");
        }
        // 检查用户名的正确性 10位字符串
        if (StringUtil.isEmpty(loginName)) {
            if (loginName.length() > 10 || loginName.length() < 4) {
                throw new IllegalArgumentException("用户名为4-10个字符串！");
            }
            throw new IllegalArgumentException("用户名不能为空！");
        }
        // 检查密码的正确性 6-18位字符串
        if (StringUtil.isEmpty(password)) {
            if (loginName.length() > 18 || loginName.length() < 6) {
                throw new IllegalArgumentException("密码为6-18个字符串！");
            }
            throw new IllegalArgumentException("密码不能为空！");
        }
        // 加密字符串
        return getDefault(tel, loginName, StringUtil.encrypt(password, "MD5"));
    }

    /**
     * 生产默认类型的WyUser
     * @param tel  用户注册的手机号
     * @param loginName 用户设置的用户名
     * @param password 用户的设置的密码
     * @return 基本用户信息的WyUser对象
     */
    private WyUser getDefault(final String tel, final String loginName, final String password) {
        // 按照数据库中字段的默认值设置
        WyUser wyUser = new WyUser();
        wyUser.setId(UserUtil.getRadomUserId());
        wyUser.setName("");
        wyUser.setTel(tel);
        wyUser.setEmail("");
        wyUser.setAddr("");
        wyUser.setLoginName(loginName);
        wyUser.setPassword(password);
        wyUser.setCreateTime(new Date());
        wyUser.setLoginTime(null);
        wyUser.setLastLoginTime(null);
        wyUser.setProfile("");
        return wyUser;
    }
}
