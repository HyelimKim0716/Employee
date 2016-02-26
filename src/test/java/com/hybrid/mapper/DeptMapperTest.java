package com.hybrid.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.Dept;

public class DeptMapperTest {

	public static void main(String[] args) {
		
		// spring을 동작시켜
		// beans_db.xml에서 작성한 설계도에 따라 객체 생성까지 해줌
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("classpath:spring/beans_db.xml");
		
		SqlSessionTemplate sqlSession = (SqlSessionTemplate) ctx.getBean("sqlSessionTemplate");
		// SqlSessionTemplate sqlSession = ctx.getBean(SqlSessionTemplate.class);	// type이 하나일 경우
		
		DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
		
		List<Dept> depts = deptMapper.selectAll();
		for(Dept d : depts){
			System.out.println(d.getDeptno() + ", " + d.getDname() + ", " + d.getLoc());
		}
		
		ctx.close();
	}

}
