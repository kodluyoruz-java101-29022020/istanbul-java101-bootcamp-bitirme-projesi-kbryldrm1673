package com.spring.boot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import com.spring.boot.annotion.MethodRunTime;

@Aspect
@Component
public class MethodRunTimeAspect {
	

	@Around("@annotation(methodRunningTime1)")
	public Object execute(ProceedingJoinPoint point, MethodRunTime methodRunningTime1) throws Throwable {
		
		if(!methodRunningTime1.active()) {
			return point.proceed();
		}
		
		String className = point.getSignature().getDeclaringType().getSimpleName();
		String methodName = point.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		
		Object result = point.proceed();
		
		stopWatch.stop();
		
		
		System.out.println(className + "#" + methodName + " runned in  " + stopWatch.getTotalTimeMillis() + " ms");
		
		
		return result;
	}
	

}
