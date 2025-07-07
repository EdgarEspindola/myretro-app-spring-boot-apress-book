package com.example.myretro.advice;

import java.util.Optional;
import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.myretro.board.RetroBoard;
import com.example.myretro.exception.RetroBoardNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class RetroBoardAdvice {

    @Around("execution(* com.example.myretro.persistence.RetroBoardRepository.findById(..))")
    public Object checkFindRetroBoard(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.debug("[ADVICE] {}", proceedingJoinPoint.getSignature().getName());
        Optional<RetroBoard> retroBoard = (Optional<RetroBoard>) proceedingJoinPoint.proceed(new Object[] {
            UUID.fromString(proceedingJoinPoint.getArgs()[0].toString())
        });
        if (retroBoard.isEmpty()) {
            throw new RetroBoardNotFoundException();
        }

        return retroBoard;
    }
}
