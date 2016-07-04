package com.importnew;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	private static ApplicationContext context;

	public static void main(String[] args) {

		// BuildAppWithXml();
		// BuildAppWithSpringConfig();
		BuildAppWithAutoScanSpring();
	}

	/*
	 * using xml boot Spring
	 * 
	 */
	@SuppressWarnings("unused")
	private static void BuildAppWithXml() {
		context = new ClassPathXmlApplicationContext("Beans2.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		if (obj != null) {
			obj.printeMessage();
		}
	}

	/*
	 * using SpringConfig boot spring
	 * 
	 */
	@SuppressWarnings("unused")
	private static void BuildAppWithSpringConfig() {

		context = new AnnotationConfigApplicationContext(AppConfig.class);
		// IPrint print = context.getBean(IPrint.class); // using Type.class
		IPrint print = (IPrint) context.getBean("Print");// using bean name
		if (print != null) {
			print.print("SpringConfig works.");
		}

		print = (IPrint) context.getBean("Print2");
		if (print != null) {
			print.print("SpringConfig Import Test");
		}

	}

	private static void BuildAppWithAutoScanSpring() {
		context = new ClassPathXmlApplicationContext("AutoScanBeans.xml");
		HelloWorld obj = context.getBean(HelloWorld.class);
		if (obj != null) {
			obj.setMessage("Spring Auto Scan Beans.");
			obj.printeMessage();
		}
	}

}
