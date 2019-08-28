package cn.ljtnono.wyapp.service;

import cn.ljtnono.wyapp.entity.WyUser;
/**
 *  用户请求接口
 *  @author ljt
 *  @date 2019/5/29
 *  @version 1.0
*/
public interface WyUserService {

    /**
     * 根据id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    WyUser getUserById(final String id);

    /**
     * 根据name获取用户信息
     * @param name 用户id
     * @return 用户信息
     */
    WyUser getUserByName(final String name);

    /**
     * 处理用户注册业务
     * @param loginName 用户名
     * @param password 用户密码
     * @param tel 用户手机
     * @return 注册后的WyUser对象
     */
    WyUser regist(final String loginName, final String password, final String tel);

    /**
     *  验证用户名是否存在重复的
     * @param loginName 注册时的用户名
     * @return 重复返回true  不重复返回false 传入参数为null也返回false
     */
    boolean checkRepeat(final String loginName);

    /**
     * 根据用户名和密码登录
     * @param loginName 用户名
     * @param password 密码（未加密之前）
     * @return 成功返回携带登陆用户信息的WyUser对象，失败返回null，参数为空也返回null
     */
    WyUser loginByLoginName(final String loginName, final String password);
    
}
