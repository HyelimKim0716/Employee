package com.hybrid.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hybrid.model.Dept;

public class JsonTest {
	
	public static void main(String[] args) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();	// json library를 포함시켜서 가능
		
		List<Dept> depts = new ArrayList<>();
		
		Dept d = new Dept();
		d.setDeptno(10);
		d.setDname("총무부");
		d.setLoc("서울");
		
		Dept d1 = new Dept();
		d1.setDeptno(20);
		d1.setDname("개발부");
		d1.setLoc("부산");
		
		depts.add(d);
		depts.add(d1);
		
		String json = mapper.writeValueAsString(depts);	// 겍체를 json string형태로 변환시켜줌
		
		System.out.println("json = " + json);
	}
}
