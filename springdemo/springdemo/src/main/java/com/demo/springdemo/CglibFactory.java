package com.demo.springdemo;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibFactory implements MethodInterceptor {

	private Object target;

	public Object creatUserDao(Object target) {

		this.target = target;

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);

		return enhancer.create();
	}

	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

		UserDaoImpl userDao = (UserDaoImpl) target;
		if (userDao.getName() != null) {
			method.invoke(target, args);

		} else {
			System.out.println("The name is null;");
		}

		return null;
	}

}
