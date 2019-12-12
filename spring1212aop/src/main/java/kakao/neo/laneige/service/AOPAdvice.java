package kakao.neo.laneige.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
//AOP 클래스로 설정
@Aspect
public class AOPAdvice {
	@Around(
			"execution(public * kakao.neo.laneige..*Controller.*(..))"
			)
	public Object invoke(ProceedingJoinPoint joinpoint) {
		Object obj = null;
		try {
			System.out.println("메소드 수행 전에 호출");
			obj = joinpoint.proceed();
		}catch(Throwable e) {
			System.out.println(e.getMessage());
		}
		
		
		return obj;
	}

}
