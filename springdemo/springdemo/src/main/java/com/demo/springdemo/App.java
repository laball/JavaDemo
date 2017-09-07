package com.demo.springdemo;

public class App {
	public static void main(String[] args) {
		
		System.out.println("App Exit.");
	}

	public static void CglibAOPTest() {

		CglibFactory cf = new CglibFactory();

		UserDaoImpl temp = new UserDaoImpl();

		UserDaoImpl userdao = (UserDaoImpl) cf.creatUserDao(temp);
		userdao.save();

		temp.setName("Laball Lee");

		userdao = (UserDaoImpl) cf.creatUserDao(temp);
		userdao.save();
	}
}
