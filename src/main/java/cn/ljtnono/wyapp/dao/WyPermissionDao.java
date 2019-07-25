package cn.ljtnono.wyapp.dao;

import cn.ljtnono.wyapp.entity.WyPermission;
import cn.ljtnono.wyapp.entity.WyPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WyPermissionDao {
    long countByExample(WyPermissionExample example);

    int deleteByExample(WyPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WyPermission record);

    int insertSelective(WyPermission record);

    List<WyPermission> selectByExample(WyPermissionExample example);

    WyPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WyPermission record, @Param("example") WyPermissionExample example);

    int updateByExample(@Param("record") WyPermission record, @Param("example") WyPermissionExample example);

    int updateByPrimaryKeySelective(WyPermission record);

    int updateByPrimaryKey(WyPermission record);
}