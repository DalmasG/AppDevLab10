package com.example.SpringPetDatabase.aspects;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAOP {

    @Before("execution(* com.example.SpringPetDatabase.services.*.*(..))")
    public void logBeforeMethodExecution() {
        System.out.println("Before method execution");
    }

    @After("execution(* com.example.SpringPetDatabase.services.*.*(..))")
    public void logAfterMethodExecution() {
        System.out.println("After method execution");
    }

    @AfterReturning(pointcut = "execution(* com.example.SpringPetDatabase.services.*.*(..))", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("After returning: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.SpringPetDatabase.services.*.*(..))", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        System.out.println("Exception thrown: " + exception.getMessage());
    }

    @Around("execution(* com.example.SpringPetDatabase.services.*.*(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before method: " + joinPoint.getSignature());
        Object result = joinPoint.proceed(); 
        System.out.println("After method: " + joinPoint.getSignature());
        return result;
    }
}
