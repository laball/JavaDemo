package com.importnew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // ("HelloWorld")
public class HelloWorld {

	private String message;

	private IPrint printer;

	@Autowired
	ConsolePrinter consolePrinter;

	public IPrint getPrinter() {
		return printer;
	}

	public void setPrinter(IPrint printer) {
		this.printer = printer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void printeMessage() {
		if (this.printer != null) {
			this.printer.print(message);
		}

		if (consolePrinter != null) {
			this.consolePrinter.print(message);
		}

	}

}
