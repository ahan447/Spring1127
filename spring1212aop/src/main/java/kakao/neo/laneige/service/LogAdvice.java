package kakao.neo.laneige.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

//클래스의 bean을 자동 생성 - logAdvice
@Component
public class LogAdvice {
	public Object invoke(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		try {
		long start = System.currentTimeMillis();
		
		//원래 메소드 수행
		obj = joinPoint.proceed();
		long end = System.currentTimeMillis(); 
		
		
		System.out.println("메소드 수행 시간 : " + (end-start));
		}catch(Throwable e) {
			System.out.println(e.getMessage());
		}
		
		return obj;
	}
}
