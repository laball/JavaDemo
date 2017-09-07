package com.demo.springdemo;

public class UserDaoFactory {
	
	public static UserDao getUserDao()
    {
        return new UserDaoImpl();
    }
}
