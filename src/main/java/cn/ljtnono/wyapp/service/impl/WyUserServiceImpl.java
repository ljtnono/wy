package cn.ljtnono.wyapp.service.impl;

import cn.ljtnono.wyapp.dao.WyUserDao;
import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.entity.WyUserExample;
import cn.ljtnono.wyapp.entity.factory.WyFactory;
import cn.ljtnono.wyapp.entity.factory.WyUserFactory;
import cn.ljtnono.wyapp.service.WyUserService;
import cn.ljtnono.wyapp.utils.StringUtil;
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
    public WyUser getUserById(final String id) {
        return wyUserDao.selectByPrimaryKey(id);
    }

    @Override
    public WyUser getUserByName(final String name) {
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
    public WyUser regist(final String loginName, final String password, final String tel) {
        WyFactory wyFactory = new WyUserFactory();
        WyUser user = (WyUser) wyFactory.create(loginName, password, tel);
        int insert = wyUserDao.insertSelective(user);
        return insert > 0 ? user : null;
    }

    /**
     * 验证用户名是否存在重复的
     *
     * @param loginName 注册时的用户名
     * @return 重复返回true  不重复返回false  传入参数为null也返回false
     */
    @Override
    public boolean checkRepeat(final String loginName) {
        if (StringUtil.isEmpty(loginName)) {
            return false;
        }
        WyUserExample wyUserExample = new WyUserExample();
        WyUserExample.Criteria criteria = wyUserExample.createCriteria();
        criteria.andLoginNameEqualTo(loginName);
        List<WyUser> wyUsers = wyUserDao.selectByExample(wyUserExample);
        return !wyUsers.isEmpty();
    }

}
