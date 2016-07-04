package com.importnew;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * using "@Configuration" to tell spring this is the main spring config using
 * "@Import" to import other SpringConfig
 * 
 */
@Configuration
@Import(OtherConfig.class)
public class AppConfig {

	@Bean(name = "Print")
	public IPrint Print() {

		return new StartPrinter();
	}
}
