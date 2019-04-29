package com.oracle.configuration;

import org.python.util.PythonInterpreter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public PythonInterpreter getInterpreted (){
		return new PythonInterpreter();
	}
}
