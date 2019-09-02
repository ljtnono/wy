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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *  用户service实现类
 *  @author ljt
 *  @date 2019/5/28
 *  @version 1.0
*/
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = {Exception.class})
public class WyUserServiceImpl implements WyUserService {

    @Autowired
    private WyUserDao wyUserDao;

    @Transactional(readOnly = true)
    @Override
    public WyUser getUserById(final String id) {
        return wyUserDao.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
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
    
    /**
     * 根据用户名和密码登陆
     * @param loginName 登陆用户名
     * @param password 登陆的密码
     * @return 登陆成功返回登陆的WyUser对象，失败返回null，用户名和密码为空也返回null
     */
    @Override
    public WyUser loginByLoginName(final String loginName, final String password) {
    	if (StringUtil.isEmpty(loginName) || StringUtil.isEmpty(password)) {
    		return null;
    	}
    	WyUserExample wyUserExample = new WyUserExample();
    	WyUserExample.Criteria criteria = wyUserExample.createCriteria();
    	criteria.andLoginNameEqualTo(loginName);
    	criteria.andPasswordEqualTo(StringUtil.encrypt(password, "MD5"));
    	List<WyUser> wyUsers = wyUserDao.selectByExample(wyUserExample);
    	if (wyUsers == null || wyUsers.size() == 0) {
    	    return null;
        }
    	// 设置登录时间为当前时间，并且根据登陆时间
    	WyUser user = new WyUser();
    	user.setLoginTime(new Date());
    	wyUserDao.updateByExampleSelective(user, wyUserExample);
    	return wyUsers.get(0);
    }
    
    /**
     * 修改密码
     * @param user 需要修改密码的WyUser对象
     * @param newPassword 新的密码
     * @throw NullPointException 当传入的user对象为null时抛出此异常
     * @throw IllegargumentException 当出现参数异常时抛出此异常
     * @return 修改成功返回true 修改失败返回false
     **/
    @Override
    public boolean updatePassword(final WyUser user, final String newPassword) {
    	if (user == null) {
    		throw new NullPointException("参数不能为null");
    	}	
    	if (StringUtil.isEmpty(user.getUserName()) || StringUtil.isEmpty(user.getPassword) || StringUtil.isEmpty(user.getTel())) {
    		throw new IllegargumentException("参数不能为空");
    	}
    		
    }
}
