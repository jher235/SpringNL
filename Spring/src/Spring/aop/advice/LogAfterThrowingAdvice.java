package Spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice {//어떤 예외가 발생할지 모름

	
	public void afterThrowing(IllegalArgumentException e) throws Throwable{
		System.out.println("예외 발생:"+e.getMessage());
	}
	
	
}
