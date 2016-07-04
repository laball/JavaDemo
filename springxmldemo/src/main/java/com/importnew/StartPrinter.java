package com.importnew;

public class StartPrinter implements IPrint {

	@Override
	public void print(String message) {

		System.out.print("\r\n***" + message + "***");
	}
}
