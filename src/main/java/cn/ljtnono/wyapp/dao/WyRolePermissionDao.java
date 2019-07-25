package cn.ljtnono.wyapp.dao;

import cn.ljtnono.wyapp.entity.WyRolePermission;
import cn.ljtnono.wyapp.entity.WyRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WyRolePermissionDao {
    long countByExample(WyRolePermissionExample example);

    int deleteByExample(WyRolePermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WyRolePermission record);

    int insertSelective(WyRolePermission record);

    List<WyRolePermission> selectByExample(WyRolePermissionExample example);

    WyRolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WyRolePermission record, @Param("example") WyRolePermissionExample example);

    int updateByExample(@Param("record") WyRolePermission record, @Param("example") WyRolePermissionExample example);

    int updateByPrimaryKeySelective(WyRolePermission record);

    int updateByPrimaryKey(WyRolePermission record);
}