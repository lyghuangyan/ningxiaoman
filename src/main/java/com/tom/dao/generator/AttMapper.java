package com.tom.dao.generator;

import com.tom.model.generator.Att;
import com.tom.model.generator.AttExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttMapper {
    long countByExample(AttExample example);

    int deleteByExample(AttExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Att record);

    int insertSelective(Att record);

    List<Att> selectByExample(AttExample example);

    Att selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Att record, @Param("example") AttExample example);

    int updateByExample(@Param("record") Att record, @Param("example") AttExample example);

    int updateByPrimaryKeySelective(Att record);

    int updateByPrimaryKey(Att record);
}