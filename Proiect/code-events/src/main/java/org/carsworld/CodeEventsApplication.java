package org.carsworld;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Aspect
@SpringBootApplication
public class CodeEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeEventsApplication.class, args);
	}

}
