package cn.ljtnono.wyapp.service.impl;

import cn.ljtnono.wyapp.dao.WyUserDao;
import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.entity.WyUserExample;
import cn.ljtnono.wyapp.entity.factory.WyFactory;
import cn.ljtnono.wyapp.entity.factory.WyUserFactory;
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

    /**
     * 处理用户注册业务
     *
     * @param loginName 用户名
     * @param password  用户密码
     * @param tel       用户手机
     * @return 注册成功返回注册后的WyUser对象，注册失败返回null
     */
    @Override
    public WyUser regist(String loginName, String password, String tel) {
        WyFactory wyFactory = new WyUserFactory();
        WyUser user = (WyUser) wyFactory.create(loginName, password, tel);
        int insert = wyUserDao.insert(user);
        return insert > 0 ? user : null;
    }

}
