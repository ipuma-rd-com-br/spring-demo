package br.com.rd.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/spring-demo");
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
