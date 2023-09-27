package hr.apisit.cinemamvc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class FilmServiceAspect {

    @Before(value = "execution(* hr.apisit.cinemamvc.service.FilmService.*(..)) && args(id)")
    public void beforeGettingFilmById(JoinPoint joinPoint, Integer id) {
        log.trace("Before method:" + joinPoint.getSignature());
        log.trace("Getting the film by id " + id);
    }

    @After(value = "execution(* hr.apisit.cinemamvc.service.FilmService.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        log.trace("After method:" + joinPoint.getSignature());
    }


}
