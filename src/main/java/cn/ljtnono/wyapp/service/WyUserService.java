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
    WyUser getUserById(String id);

    /**
     * 根据name获取用户信息
     * @param name 用户id
     * @return 用户信息
     */
    WyUser getUserByName(String name);
}
