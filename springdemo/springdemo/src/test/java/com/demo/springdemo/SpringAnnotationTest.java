package com.demo.springdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.demo.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class SpringAnnotationTest extends UnitTestBase {

	public SpringAnnotationTest() {
		super("classpath*:AnnotationBeans.xml");
	}

	@Test
	public void AnnotationTest() {

		UserService userService = getBean(UserService.class);
		userService.getUserDao().save();

		userService = getBean("UserService");
		userService.getUserDao().save();
	}
}
