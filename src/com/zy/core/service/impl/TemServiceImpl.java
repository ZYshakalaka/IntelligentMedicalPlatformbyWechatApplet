package com.zy.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.core.dao.TemMapper;
import com.zy.core.model.Tem;
import com.zy.core.model.TemExample;
import com.zy.core.service.DaService;

@Service("temService")
public class TemServiceImpl implements DaService<Tem, TemExample>{

	@Autowired
	private TemMapper tem;

	@Override
	public int countByExample(TemExample example) {
		
		return tem.countByExample(example);
	}

	@Override
	public int deleteByExample(TemExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Tem record) {
		
		return tem.insert(record);
	}

	@Override
	public int insertSelective(Tem record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Tem> selectByExample(TemExample example) {
		
		return tem.selectByExample(example);
	}

	@Override
	public Tem selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Tem record, TemExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Tem record, TemExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Tem record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Tem record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertByExample(TemExample example) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

/** 
* @date:2017年7月8日 
* @author:zouyu
*/ 