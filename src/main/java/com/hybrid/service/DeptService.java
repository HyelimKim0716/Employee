package com.hybrid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.model.Dept;

@Service	// spring에게 bean으로 자동등록 해달라고 요청
public class DeptService {
	
	// 필드주입
	@Autowired		// Spring Factory에 자동으로 주입(DI)하라는 의미
	DeptMapper deptMapper;
	
	// DB시작 시 자동으로 transaction 처리
	@Transactional	 	// (에러 날 경우 자동으로 rollack하고 성공하면 commit
	public List<Dept> getList(){
		
		List<Dept> depts = deptMapper.selectAll();
		
		return depts;
	}
	
	@Transactional
	public Dept getDept(Integer deptno){
		
		return deptMapper.selectByDeptno(deptno);
	}
	
	// insert
	@Transactional
	public void insert(Dept dept){
		deptMapper.insert(dept);
	}
	
	// delete
	@Transactional
	public Dept delete(Integer deptno){
		Dept dept = deptMapper.selectByDeptno(deptno);
		deptMapper.deleteByDeptno(deptno);
		
		return dept;
	}
}
