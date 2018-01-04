package com.example.demo.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OutputLog {
	@Before("execution(* com.example.demo.dao.Sample2Dao.*(..))")
	private void beforeOutLog(JoinPoint jp) {
		String from = "Before";
		System.out.println(from + ":" + jp.getTarget().getClass().getSimpleName() + "." + jp.getSignature().getName());
		Object[] args = jp.getArgs();
		for (Object o : args) {
			System.out.println(from + ":" + o);
		}
	}
}
