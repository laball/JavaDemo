package com.importnew;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfig {

	@Bean(name = "Print2")
	public IPrint Print() {

		return new ConsolePrinter();
	}

}
