package com.zy.core.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * ProjectName: sgorder
 * PackageName: com.sgyf.core.service
 * Created by lizhe on 2016/11/1.
 */

/**
 *
 * @param <T> dao
 * @param <E>daoExample
 */
public interface DaService<T,E> {
    int countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(Integer id);

    int insert(T record);
    
    int insertByExample(E example);

    int insertSelective(T record);

    List<T> selectByExample(E example);

    T selectByPrimaryKey(int id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
