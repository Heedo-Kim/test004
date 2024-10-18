package com.example.test004.aspect;

import com.example.test004.config.DB_TYPE;
import com.example.test004.config.DatabaseContextHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

@Aspect
@Order(1)
@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAspect {
    @Around("@annotation(com.example.test004.annotation.Custom)")
    public Object processCustomAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("start custom aspect");
        DatabaseContextHolder.set(DB_TYPE.READ);
        Object proceedReturnValue = proceedingJoinPoint.proceed();
        DatabaseContextHolder.set(DB_TYPE.WRITE);
        log.info("end custom aspect");
        return proceedReturnValue;
    }
}
