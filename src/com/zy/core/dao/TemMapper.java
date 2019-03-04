package com.zy.core.dao;

import com.zy.core.model.Tem;
import com.zy.core.model.TemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemMapper {
    int countByExample(TemExample example);

    int deleteByExample(TemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tem record);

    int insertSelective(Tem record);

    List<Tem> selectByExample(TemExample example);

    Tem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tem record, @Param("example") TemExample example);

    int updateByExample(@Param("record") Tem record, @Param("example") TemExample example);

    int updateByPrimaryKeySelective(Tem record);

    int updateByPrimaryKey(Tem record);
}