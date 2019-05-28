package cn.ljtnono.wyapp.service;

import cn.ljtnono.wyapp.entity.WyUser;

public interface WyUserService {

    WyUser getUserById(String id);

    WyUser getUserByName(String name);
}
