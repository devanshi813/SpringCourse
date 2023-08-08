package com.luv2code.aopdemo;

import com.luv2code.aopdemo.Dao.AccountDAO;
import com.luv2code.aopdemo.Dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return args -> demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// call the business method from AccountDAO
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the business method from MembershipDAO
		theMembershipDAO.addSillyMember();
		theMembershipDAO.gotosleep();
	}
}
