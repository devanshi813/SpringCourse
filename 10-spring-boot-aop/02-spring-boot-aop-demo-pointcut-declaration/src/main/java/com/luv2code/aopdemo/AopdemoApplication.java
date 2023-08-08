package com.luv2code.aopdemo;

import com.luv2code.aopdemo.Dao.AccountDAO;
import com.luv2code.aopdemo.Dao.MembershipDAO;
import com.luv2code.aopdemo.Service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService) {
		return args ->
//				demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
//				demoTheAfterReturningAdvice(theAccountDAO);
//				demoTheAfterThrowingAdvice(theAccountDAO);
//				demoTheAfterAdvice(theAccountDAO);
//				demoTheAroundService(theTrafficFortuneService);
//				demoTheAroundAdviceHandleException(theTrafficFortuneService);
				demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");

		System.out.println("Calling getFortune");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy Fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy Fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundService(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\nMy Fortune is: " + data);

		System.out.println("Finished");

	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = null;

		try{
			boolean tripWire = false;
			theAccounts =  theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("\n\nMain Program ... caught exception" + exc);
		}

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterRunningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = null;

		try{
			boolean tripWire = true;
			theAccounts =  theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("\n\nMain Program ... caught exception" + exc);
		}

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterRunningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterRunningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");


	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// call the business method from AccountDAO
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("footbar");
		theAccountDAO.setName("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the business method from MembershipDAO
		theMembershipDAO.addSillyMember();
		theMembershipDAO.gotosleep();
	}
}
