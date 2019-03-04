package com.zy.core.dao;

import com.zy.core.model.RateDescribe;
import com.zy.core.model.RateDescribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RateDescribeMapper {
    int countByExample(RateDescribeExample example);

    int deleteByExample(RateDescribeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RateDescribe record);

    int insertSelective(RateDescribe record);

    List<RateDescribe> selectByExampleWithBLOBs(RateDescribeExample example);

    List<RateDescribe> selectByExample(RateDescribeExample example);

    RateDescribe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RateDescribe record, @Param("example") RateDescribeExample example);

    int updateByExampleWithBLOBs(@Param("record") RateDescribe record, @Param("example") RateDescribeExample example);

    int updateByExample(@Param("record") RateDescribe record, @Param("example") RateDescribeExample example);

    int updateByPrimaryKeySelective(RateDescribe record);

    int updateByPrimaryKeyWithBLOBs(RateDescribe record);

    int updateByPrimaryKey(RateDescribe record);
}