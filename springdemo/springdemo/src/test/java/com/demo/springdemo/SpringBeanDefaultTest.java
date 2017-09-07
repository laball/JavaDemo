package com.demo.springdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.demo.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class SpringBeanDefaultTest extends UnitTestBase {

	public SpringBeanDefaultTest() {
		super("classpath*:beans.xml");
	}

	@Test
	public void DaoTest() {

		// by bean ID
		UserDao userDao = getBean("userDaoImpl");
		userDao.save();

		// by interface Class
		// userDao = getBean(UserDao.class);
		// userDao.save();

		// by Class
		// userDao = getBean(UserDaoImpl.class);
		// userDao.save();
	}

	@Test
	public void ComplexObjectInjectTest() {

		UserService userService = getBean(UserService.class);
		userService.PrintInof();
	}

	@Test
	public void BeanFactoryTest() {

		UserDao userDao = getBean("userDaoImpl_Static_Factory_Method");
		userDao.save();

		userDao = getBean("userDaoImpl_Factory_Bean");
		userDao.save();
	}

}
