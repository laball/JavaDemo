/**
 * 
 */
package com.demo.springdemo;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */

@Component
public class UserDaoImpl implements UserDao {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void save() {
		System.out.println("save() is called.");
	}
}
