package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.aopdemo.Service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Excecuting @@Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;

        try{
            result = theProceedingJoinPoint.proceed();
        }catch (Exception exc){
            // log the exception
            System.out.println(exc.getMessage());

//            // give user a custome message
//            System.out.println("Major accident! But no worries, your private helicopter is coming");

            // rethrow exception
            throw exc;
        }

        // get and timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end-begin;
        System.out.println("\n====> Duration: " + duration / 1000.0 + "seconds");

        return result;

    }


    @After("execution(* com.luv2code.aopdemo.Dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Excecuting @After (finally) on method: " + method);

    }

    @AfterThrowing(
        pointcut = "execution(* com.luv2code.aopdemo.Dao.AccountDAO.findAccounts(..))",
        throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
        JoinPoint theJoinPoint, Throwable theExc){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Excecuting @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + theExc);
    }

    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.Dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        // Print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterReturning on method: " + method);

        // Print out the results of the method call
        System.out.println("\n=====>>> Result is: " + result);

        // lets post process the data ... lets modify
        ;
        // convert tye account name to uppercase
        convertAccountNameToUpperCase(result);
        System.out.println("\n=====>>> Result is: " + result);

    }

    private void convertAccountNameToUpperCase(List<Account> result) {

        // loop thorugh accounts
        for(Account tempAccount : result){

            // get uppercase version of name
            String theUpperName =  tempAccount.getName();

            // update the name on teh account
            tempAccount.setName(theUpperName);
        }

    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");


        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get the args
        Object[] args = theJoinPoint.getArgs();

        // loop throught those args
        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                // downcast and print Account specific effect
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account lever: "+ theAccount.getName());
            }
        }


    }





}
