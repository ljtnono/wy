package cn.ljtnono.wyapp.dao;

import cn.ljtnono.wyapp.entity.WyUser;
import cn.ljtnono.wyapp.entity.WyUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WyUserDao {
    long countByExample(WyUserExample example);

    int deleteByExample(WyUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(WyUser record);

    int insertSelective(WyUser record);

    List<WyUser> selectByExample(WyUserExample example);

    WyUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WyUser record, @Param("example") WyUserExample example);

    int updateByExample(@Param("record") WyUser record, @Param("example") WyUserExample example);

    int updateByPrimaryKeySelective(WyUser record);

    int updateByPrimaryKey(WyUser record);
}