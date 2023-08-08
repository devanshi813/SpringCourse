package com.luv2code.aopdemo.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addSillyMember(){
        System.out.println(getClass() + ": Doing my db work: Adding an account");
        return  true;
    }

    @Override
    public void gotosleep(){
        System.out.println(getClass() + ":  Imma go to sleep now");
    }

}
