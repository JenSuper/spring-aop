package com.example.springaop.aop;

import com.example.springaop.controller.HelloController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * All rights Reserved, Designed By www.rongdasoft.com
 *
 * @version V1.0
 * @Title: WebAspect
 * @Description:
 * @author:jichao
 * @date: 2019/3/22
 * @Copyright: 2019/3/22 www.rongdasoft.com
 * Inc. All rights reserved.
 */
@Aspect
@Component
public class WebAspect {

    private static Logger logger = LoggerFactory.getLogger(WebAspect.class);

    @Pointcut("execution(public * com.example.springaop..*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String remoteHost = request.getRemoteHost();
        String requestURI = request.getRequestURI();
        String servletPath = request.getServletPath();
        String remoteAddr = request.getRemoteAddr();
        Object[] args = joinPoint.getArgs();
        logger.info("remoteHost "+remoteHost);
        logger.info("requestURI "+requestURI);
        logger.info("servletPath "+servletPath);
        logger.info("remoteAddr "+remoteAddr);
        logger.info("args "+args);
        System.out.println("doBefore()");
    }

    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("doAfter");
    }

    @AfterReturning(returning = "ret", pointcut = "pointcut()")
    public void doAfterReturning(Object ret) {
        System.out.println("doAfterReturning");
    }
}
