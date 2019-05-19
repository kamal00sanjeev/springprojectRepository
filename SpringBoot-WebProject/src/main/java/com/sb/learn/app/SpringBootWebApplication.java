/**
 * 
 */
package com.sb.learn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Sanjeev
 *
 */
@SpringBootApplication
@ComponentScan("com.sb.learn")
public class SpringBootWebApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
