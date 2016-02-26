package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.Dept;

public interface DeptMapper {
	
	// selectAll 호출 시 
	List<Dept> selectAll();
	Dept selectByDeptno(int deptno);
	int insert(Dept dept);
	int updateByDeptno(Dept dept);
	int deleteByDeptno(int deptno);
	
}
