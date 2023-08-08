package com.luv2code.aopdemo.Dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for academic purposes .. simulate an exception

        if(tripWire){
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // craete sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        return myAccounts;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println(getClass() + ": Doing my db work: Adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+ " : dowork");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+ " : in getname");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+ " : in setname");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+ " : in getservicecode ");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+ " : in setservicecode");
        this.serviceCode = serviceCode;
    }


}
