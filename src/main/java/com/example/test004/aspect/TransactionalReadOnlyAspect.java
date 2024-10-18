package com.example.test004.aspect;

import com.example.test004.config.DB_TYPE;
import com.example.test004.config.DatabaseContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
@Slf4j
public class TransactionalReadOnlyAspect {

    @Around("@annotation(transactional)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint,
                          org.springframework.transaction.annotation.Transactional transactional)
            throws Throwable {
        log.info("Aspect called transactional.readOnly {} {}", transactional.readOnly(), DatabaseContextHolder.getDbType());
        try {
            if (transactional.readOnly()) {
                DatabaseContextHolder.set(DB_TYPE.READ);
            }
            return proceedingJoinPoint.proceed();
        } finally {
            DatabaseContextHolder.reset();
            log.info("context reset");
        }
    }
}
