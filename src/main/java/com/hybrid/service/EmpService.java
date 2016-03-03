package com.hybrid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hybrid.mapper.EmpMapper;
import com.hybrid.model.Emp;

@Service	// spring에게 bean으로 자동등록 해달라고 요청
public class EmpService {
	
	// 필드주입
	@Autowired		// Spring Factory에 자동으로 주입(DI)하라는 의미
	EmpMapper empMapper;
	
	// DB시작 시 자동으로 transaction 처리
	@Transactional	 	// (에러 날 경우 자동으로 rollack하고 성공하면 commit
	public List<Emp> getList(){
		
		List<Emp> emps = empMapper.selectAll();
		
		return emps;
	}
	
	@Transactional
	public Emp getEmp(Integer empno){
		
		return empMapper.selectByEmpno(empno);
	}
	
	// insert
	@Transactional
	public void insert(Emp emp){
		empMapper.insert(emp);
	}
	
	// delete
	@Transactional
	public Emp delete(Integer empno){
		Emp emp = empMapper.selectByEmpno(empno);
		empMapper.deleteByEmpno(empno);
		
		return emp;
	}
}
