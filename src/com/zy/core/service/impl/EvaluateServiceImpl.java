package com.zy.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.core.dao.EvaluateMapper;
import com.zy.core.dao.PressMapper;
import com.zy.core.dao.TemMapper;
import com.zy.core.model.Evaluate;
import com.zy.core.model.EvaluateExample;
import com.zy.core.model.Press;
import com.zy.core.model.PressExample;
import com.zy.core.model.Tem;
import com.zy.core.model.TemExample;
import com.zy.core.service.DaService;

@Service("evaluateService")
public class EvaluateServiceImpl implements DaService<Evaluate,EvaluateExample>{

	@Autowired
	private EvaluateMapper evaluate;

	@Override
	public int countByExample(EvaluateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(EvaluateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Evaluate record) {
		return evaluate.insert(record);
	}

	@Override
	public int insertByExample(EvaluateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Evaluate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Evaluate> selectByExample(EvaluateExample example) {
		return evaluate.selectByExample(example);
	}

	@Override
	public Evaluate selectByPrimaryKey(int id) {
		return evaluate.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Evaluate record, EvaluateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Evaluate record, EvaluateExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Evaluate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Evaluate record) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}

/** 
* @date:2017年7月8日 
* @author:zouyu
*/ 