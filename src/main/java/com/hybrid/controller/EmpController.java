package com.hybrid.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.model.Emp;
import com.hybrid.service.EmpService;

@Controller	// "/dept/list"에 의해 mapping
public class EmpController {
	
	static Log log = LogFactory.getLog(EmpController.class);

	@Autowired	// 공장에 있는 EmpService를 필드주입
	EmpService empService;
	
	@RequestMapping(value="/emp/list")
	@ResponseBody
	// selectAll
	public Map<String, Object> getList() {
		Map<String, Object> result = new HashMap<>(); 
		result.put("success", true);
		result.put("message", "조회성공");
		
		result.put("data", empService.getList());
		return result;
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	@ResponseBody
	//selectById
	public Emp getEmp(Integer empno){
		log.info("getEmp(); empno = " + empno);

		return empService.getEmp(empno);
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.POST)
	@ResponseBody
	// insert
	public Emp postEmp(Emp emp){
		log.info("empno = " + emp.getEmpno());
	
		empService.insert(emp);
		
		return emp;
	}
	
	@RequestMapping(value="/emp", method=RequestMethod.DELETE)
	@ResponseBody
	public Emp deleteEmp(Integer empno){
		return empService.delete(empno);
	}
}
