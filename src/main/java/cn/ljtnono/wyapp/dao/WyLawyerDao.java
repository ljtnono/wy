package cn.ljtnono.wyapp.dao;

import cn.ljtnono.wyapp.entity.WyLawyer;
import cn.ljtnono.wyapp.entity.WyLawyerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WyLawyerDao {
    long countByExample(WyLawyerExample example);

    int deleteByExample(WyLawyerExample example);

    int deleteByPrimaryKey(String id);

    int insert(WyLawyer record);

    int insertSelective(WyLawyer record);

    List<WyLawyer> selectByExample(WyLawyerExample example);

    WyLawyer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WyLawyer record, @Param("example") WyLawyerExample example);

    int updateByExample(@Param("record") WyLawyer record, @Param("example") WyLawyerExample example);

    int updateByPrimaryKeySelective(WyLawyer record);

    int updateByPrimaryKey(WyLawyer record);
}