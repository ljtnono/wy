package cn.ljtnono.wyapp.entity.factory;

import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.utils.UserUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 用户类创建工厂
 *  @author 凌家童
 *  @date 2019/7/21
 *  @version 1.0
 *
*/
public class WyUserFactory implements WyFactory{

    private WyUser wyUser;

    public WyUserFactory() {

    }
    /**
     * 创建用户方法
     * @param args 创建时所需要的参数，具体看各个子类的要求
     * @return WyUser实体
     */
    @Override
    public WyUser create(Object... args) {
        WyUser wyUser = new WyUser();
        if (args == null) {
            return getDefault();
        } else {
            // 根据传递的参数获取
        }
        return wyUser;
    }

    /**
     * 生产默认类型的WyUser
     * @return WyUser
     */
    private WyUser getDefault() {
        WyUser wyUser = new WyUser();
        wyUser.setLoginName(UserUtil.getRadomUserName());

        return null;
    }
}
