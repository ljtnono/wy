package cn.ljtnono.wyapp.security;

import cn.ljtnono.wyapp.dao.WyUserDao;
import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.entity.WyUserExample;
import cn.ljtnono.wyapp.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  配置数据库数据认证
 *  @author 凌家童
 *  @date 2019/9/4
 *  @version 1.0
 *
*/
@SpringBootConfiguration
public class WyAppSercurityUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private WyUserDao wyUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.isEmpty()) {
            throw new UsernameNotFoundException("用户名不能为空");
        }
        if (!UserUtil.validateLoginName(username)) {
            throw new UsernameNotFoundException("密码是6-18位字母和数字的组合 .+*-_/");
        }
        WyUserExample example = new WyUserExample();
        example.createCriteria().andLoginNameEqualTo(username);
        List<WyUser> wyUsers = wyUserDao.selectByExample(example);
        if (wyUsers == null || wyUsers.size() == 0) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        WyUser user = wyUsers.get(0);
        // 使用jdbctemplate 查询出来该用户所有的角色，然后分配角色
        List<String> roles = jdbcTemplate.queryForList("SELECT wy_role.role_name FROM wy_user_role LEFT JOIN wy_role on wy_user_role.role_id = wy_role.id WHERE wy_user_role.user_id = ?", String.class, user.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        Iterator<String> iterator = roles.iterator();
        while (iterator.hasNext()) {
            //实例化GrantedAuthority
            // 前缀加上ROLE_ springsecurity会认为这是一个角色而不是权限
            authorities.add(new SimpleGrantedAuthority("ROLE_" + iterator.next()));
        }
        return new User(user.getLoginName(), user.getPassword(), authorities);
    }
}
