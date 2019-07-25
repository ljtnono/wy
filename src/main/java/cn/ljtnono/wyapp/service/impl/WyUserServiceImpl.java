package cn.ljtnono.wyapp.service.impl;

import cn.ljtnono.wyapp.dao.WyUserDao;
import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.entity.WyUserExample;
import cn.ljtnono.wyapp.dao.WyUserDao;
import cn.ljtnono.wyapp.service.WyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  用户service实现类
 *  @author ljt
 *  @date 2019/5/28
 *  @version 1.0
*/
@Service
public class WyUserServiceImpl implements WyUserService {

    @Autowired
    private WyUserDao wyUserDao;

    @Override
    public WyUser getUserById(String id) {
        return wyUserDao.selectByPrimaryKey(id);
    }

    @Override
    public WyUser getUserByName(String name) {
        WyUserExample example = new WyUserExample();
        WyUserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<WyUser> wyUsers = wyUserDao.selectByExample(example);
        return wyUsers.get(0);
    }

}
