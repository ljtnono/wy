package cn.ljtnono.wyapp.service.impl;

import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.entity.WyUserExample;
import cn.ljtnono.wyapp.mapper.WyUserMapper;
import cn.ljtnono.wyapp.service.WyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  用户service类
 *  @author ljt
 *  @date 2019/5/28
 *  @version 1.0
*/
@Service
public class WyUserServiceImpl implements WyUserService {

    @Autowired
    private WyUserMapper wyUserMapper;

    @Override
    public WyUser getUserById(String id) {
        return wyUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public WyUser getUserByName(String name) {
        WyUserExample example = new WyUserExample();
        WyUserExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike(name);
        List<WyUser> wyUsers = wyUserMapper.selectByExample(example);
        return wyUsers.get(0);
    }

}
