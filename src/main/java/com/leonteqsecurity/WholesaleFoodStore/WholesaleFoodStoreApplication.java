package com.leonteqsecurity.WholesaleFoodStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to start the Wholesale Food Store application.
 * This class is annotated with {@code @SpringBootApplication}, combining
 * {@code @Configuration}, {@code @EnableAutoConfiguration}, and {@code @ComponentScan}.
 */
@SpringBootApplication
public class WholesaleFoodStoreApplication {

	/**
	 * The main method to start the Wholesale Food Store application.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(WholesaleFoodStoreApplication.class, args);
	}
}
