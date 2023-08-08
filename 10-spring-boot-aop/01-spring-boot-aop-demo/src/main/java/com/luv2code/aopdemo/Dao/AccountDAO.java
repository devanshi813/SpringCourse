package com.luv2code.aopdemo.Dao;

import com.luv2code.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();


}
