package cn.ljtnono.wyapp.dao;

import cn.ljtnono.wyapp.entity.WyImage;
import cn.ljtnono.wyapp.entity.WyImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WyImageDao {
    long countByExample(WyImageExample example);

    int deleteByExample(WyImageExample example);

    int deleteByPrimaryKey(String id);

    int insert(WyImage record);

    int insertSelective(WyImage record);

    List<WyImage> selectByExample(WyImageExample example);

    WyImage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WyImage record, @Param("example") WyImageExample example);

    int updateByExample(@Param("record") WyImage record, @Param("example") WyImageExample example);

    int updateByPrimaryKeySelective(WyImage record);

    int updateByPrimaryKey(WyImage record);
}