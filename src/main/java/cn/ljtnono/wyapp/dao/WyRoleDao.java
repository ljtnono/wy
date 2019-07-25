package cn.ljtnono.wyapp.dao;

import cn.ljtnono.wyapp.entity.WyRole;
import cn.ljtnono.wyapp.entity.WyRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WyRoleDao {
    long countByExample(WyRoleExample example);

    int deleteByExample(WyRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WyRole record);

    int insertSelective(WyRole record);

    List<WyRole> selectByExample(WyRoleExample example);

    WyRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WyRole record, @Param("example") WyRoleExample example);

    int updateByExample(@Param("record") WyRole record, @Param("example") WyRoleExample example);

    int updateByPrimaryKeySelective(WyRole record);

    int updateByPrimaryKey(WyRole record);
}