package com.hybrid;

import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.shape.Shape;

/**
 * Spring 동작 방법
 * Generic
 */

public class SpringTest 
{	
	static Log log = LogFactory.getLog(SpringTest.class);
	
	Shape s;
	Shape s1;
	
	SimpleDateFormat dateFormat;
	
	public void setDateFormat(SimpleDateFormat df){
		this.dateFormat = df;
	}
	
	public SpringTest(){
		log.info("SpringTest()");
	}
	
	public void setShape(Shape s){
		log.info("setShape()");
		this.s = s;
	}
	
	public void setShape1(Shape s1){
		log.info("setShape1()");
		this.s1 = s1;
	}
	
	public void print() {
		log.info("s.width = " + s.getWidth());
    	log.info("s.height = " + s.getHeight());
    	log.info("s.color = " + s.getColor());
    	log.info("s.date = " + dateFormat.format(s.getDate()));
    	
    	log.info("s1.width = " + s1.getWidth());
    	log.info("s1.height = " + s1.getHeight());
    	log.info("s1.color = " + s1.getColor());
    	log.info("s1.date = " + dateFormat.format(s1.getDate()));
	}
    public static void main( String[] args )
    {
        // Spring 동작 방법
    	// 1. Factory 만들기 : 설정파일 위치 및 파일 이름 알림
    	// * Factory : xml파일(설정파일)을 관리할 공장
    	GenericXmlApplicationContext ctx 
    		= new GenericXmlApplicationContext("spring/beans.xml");
    	
    	// 2. 공장에 있는 bean 가지고 오기 : ctx.getBean
    	// (ex1. javascript의 DOM객체에서 select() or find()와 동일)
    	// (ex2. android 에서 findViewById와 동일함)
    	// Shape s = ctx.getBean(Shape.class);
    	
    	SpringTest spring = ctx.getBean(SpringTest.class);	
    	// 하지만 공장에 SpringTest가 없으므로 error가 남
    	spring.print();
    	
    	// 공장 닫기!
    	ctx.close();
    }
}
