package com.zy.core.dao;

import com.zy.core.model.TemDescribe;
import com.zy.core.model.TemDescribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemDescribeMapper {
    int countByExample(TemDescribeExample example);

    int deleteByExample(TemDescribeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TemDescribe record);

    int insertSelective(TemDescribe record);

    List<TemDescribe> selectByExampleWithBLOBs(TemDescribeExample example);

    List<TemDescribe> selectByExample(TemDescribeExample example);

    TemDescribe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TemDescribe record, @Param("example") TemDescribeExample example);

    int updateByExampleWithBLOBs(@Param("record") TemDescribe record, @Param("example") TemDescribeExample example);

    int updateByExample(@Param("record") TemDescribe record, @Param("example") TemDescribeExample example);

    int updateByPrimaryKeySelective(TemDescribe record);

    int updateByPrimaryKeyWithBLOBs(TemDescribe record);

    int updateByPrimaryKey(TemDescribe record);
}