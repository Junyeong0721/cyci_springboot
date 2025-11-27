package kr.soft.study.app;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class StudyAspect {

    //execution(접근제어가 패키지.클래스명.메소드명())
    @Before("execution(* kr.soft.study.api.StudyController.*(..))")
    public void beforeAPI(JoinPoint joinPoint) {
        log.info("====================== BEFORE ======================");
        log.info("type-name {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName {}", joinPoint.getSignature().getName());



    }
    @After("execution(* kr.soft.study.api.StudyController.*(..))")
    public void AfterAPI(JoinPoint joinPoint) {
        log.info("====================== AFTER ======================");
        log.info("type-name {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName {}", joinPoint.getSignature().getName());


    }
    @AfterReturning("execution(* kr.soft.study.api.StudyController.*(..))")
    public void AfterReturningAPI(JoinPoint joinPoint) {
        log.info("====================== AFTER-RETURNING ======================");
        log.info("type-name {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName {}", joinPoint.getSignature().getName());


    }
    @AfterThrowing(value = "execution(* kr.soft.study.api.StudyController.*(..))", throwing = "exception")
    public void AfterThrowingAPI(JoinPoint joinPoint, Exception exception) {
        log.info("====================== AFTER-THROWING ======================");
        log.info("type-name {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName {}", joinPoint.getSignature().getName());


    }
    @Around("execution(* kr.soft.study.api.StudyController.*(..))")
    public Object afterAroundAPI(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("====================== AROUND START ======================");
        log.info("type-name {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName {}", joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        log.info("====================== AROUND END ======================");
        log.info("class : {}",  joinPoint.getSignature().getDeclaringTypeName());
        log.info("method : {}",  joinPoint.getSignature().getName());
        log.info("실행시간 :  {}ms", (end-start));

        return result;

    }
}
