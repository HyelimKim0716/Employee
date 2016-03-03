package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.Emp;

public interface EmpMapper {
	
	// selectAll 호출 시 
	List<Emp> selectAll();
	Emp selectByEmpno(int empno);
	int insert(Emp emp);
	int updateByEmpno(Emp emp);
	int deleteByEmpno(int empno);
	
}
