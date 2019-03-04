package com.zy.core.dao;

import com.zy.core.model.PressDescribe;
import com.zy.core.model.PressDescribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PressDescribeMapper {
    int countByExample(PressDescribeExample example);

    int deleteByExample(PressDescribeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PressDescribe record);

    int insertSelective(PressDescribe record);

    List<PressDescribe> selectByExampleWithBLOBs(PressDescribeExample example);

    List<PressDescribe> selectByExample(PressDescribeExample example);

    PressDescribe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PressDescribe record, @Param("example") PressDescribeExample example);

    int updateByExampleWithBLOBs(@Param("record") PressDescribe record, @Param("example") PressDescribeExample example);

    int updateByExample(@Param("record") PressDescribe record, @Param("example") PressDescribeExample example);

    int updateByPrimaryKeySelective(PressDescribe record);

    int updateByPrimaryKeyWithBLOBs(PressDescribe record);

    int updateByPrimaryKey(PressDescribe record);
}