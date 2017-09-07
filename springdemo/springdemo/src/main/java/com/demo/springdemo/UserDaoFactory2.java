package com.demo.springdemo;

public class UserDaoFactory2 {
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}
}
