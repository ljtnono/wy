package cn.ljtnono.wyapp.dao;

import cn.ljtnono.wyapp.entity.WyUserRole;
import cn.ljtnono.wyapp.entity.WyUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WyUserRoleDao {
    long countByExample(WyUserRoleExample example);

    int deleteByExample(WyUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WyUserRole record);

    int insertSelective(WyUserRole record);

    List<WyUserRole> selectByExample(WyUserRoleExample example);

    WyUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WyUserRole record, @Param("example") WyUserRoleExample example);

    int updateByExample(@Param("record") WyUserRole record, @Param("example") WyUserRoleExample example);

    int updateByPrimaryKeySelective(WyUserRole record);

    int updateByPrimaryKey(WyUserRole record);
}