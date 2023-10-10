package com.hunmo.examplespring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


/*
    @Aspect AOP를 사용하겠다는 Annotation
    Bean에 등록 (SpringConfig)
 */
@Aspect

public class TimeTraceAop {

    @Around("execution(* com.hunmo.examplespring..*(..))")
    //@Around 어디다 적용할 것인지 범위 지정
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        System.out.println("START: " + joinPoint.toString());
        try {
            // <api 서버> - clieht  - server <-> db , devops,
            // 기존에 이상한 인프라ㅏ 구축 / EA
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}
