package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
    @Pointcut("execution( * com.luv2code.aopdemo.Dao.*.*(..))")
    public void forDaoPackage(){}

    // create a pointcut for getter methods
    @Pointcut("execution( * com.luv2code.aopdemo.Dao.*.get*(..))")
    public void getter(){}

    // create a pointcut for setters methods
    @Pointcut("execution( * com.luv2code.aopdemo.Dao.*.set*(..))")
    public  void setter(){}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}


}
