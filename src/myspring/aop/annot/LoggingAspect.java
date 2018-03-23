package myspring.aop.annot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	protected static final Logger logger = LogManager.getLogger();

	// Target의 메서드가 호출 되기 전에 먼저 호출된느 Advice
	@Before("execution(public * myspring..*(..))")
	public void before(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		if (logger.isInfoEnabled()) {
			logger.info("@Before [ " + signatureString + " ] 메서드 실행 전처리 수행");
		}
		for (Object arg : joinPoint.getArgs()) {
			logger.debug("@Before [ " + signatureString + " ] 아규먼트 " + arg);
		}
	}

	// Target의 메서드가 정상적으로 종료되고 난 후에 호출되는 Advice returning- > 결과의 반환 값
	@AfterReturning(pointcut = "execution(public * myspring.user.service.*.*(..))", returning = "ret")
	public void afterReturning(JoinPoint joinPoint, Object ret) {
		String signatureString = joinPoint.getSignature().getName();
		logger.debug("@AfterReturing [ " + signatureString + " ] 메서드 실행 후처리 수행");
		logger.debug("@AfterReturing [ " + signatureString + " ] 리턴값=" + ret);

	}

	// Target의 메서드가 예외가 발생햇을 때 호출되는 Advice throwing -> Exception 설정
	@AfterThrowing(pointcut = "execution(* *..UserService*.*(..))", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		String signatureString = joinPoint.getSignature().getName();
		logger.debug("@AfterThrowing [ " + signatureString + " ] 메서드 실행 중 예외 발생");
		logger.debug("@AfterThrowing [ " + signatureString + " ] 예외=" + ex.getMessage());
	}

	// Target의 메서드의 성공/실패 여부에 상관없이 무조건 호출되는 Advice
	@After("execution(* *..*.*User(..))")
	public void afterFinally(JoinPoint joinPoint) {
		String signatureString = joinPoint.getSignature().getName();
		logger.debug("@After [ " + signatureString + " ] 메서드 실행 완료");
	}
}
