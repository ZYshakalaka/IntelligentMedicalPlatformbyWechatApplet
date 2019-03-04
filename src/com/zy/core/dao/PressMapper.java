package com.zy.core.dao;

import com.zy.core.model.Press;
import com.zy.core.model.PressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PressMapper {
    int countByExample(PressExample example);

    int deleteByExample(PressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Press record);

    int insertSelective(Press record);

    List<Press> selectByExample(PressExample example);

    Press selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Press record, @Param("example") PressExample example);

    int updateByExample(@Param("record") Press record, @Param("example") PressExample example);

    int updateByPrimaryKeySelective(Press record);

    int updateByPrimaryKey(Press record);
}