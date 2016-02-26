package com.hybrid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Hello world!
 *
 */

public class LogTest 
{	
	// 운영 상 문제가 생겼을 때 직접적으로 log4j를 사용할 경우 모든 클래스의 로그
	// log4j가 퍼포먼스의 문제 혹은 버전 성능 을 위해 교체가 필요하다면 log 교체 필요
	// log framework 
	static Log log = LogFactory.getLog(LogTest.class);
	
    public static void main( String[] args )
    {
        log.info("Hello World! Log4j");
    }
}
