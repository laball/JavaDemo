package com.importnew;

import org.springframework.stereotype.Component;

@Component
public class ConsolePrinter implements IPrint {

	@Override
	public void print(String message) {

		System.out.print("\r\n c:\\Users\\Administrator> " + message);
	}

}
