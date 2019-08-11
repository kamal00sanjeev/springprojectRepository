package com.grdl.boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HelloGradleController {

	@GetMapping
	public String helloGradle() {
		return "Hello Gradle!";
	}
	
	@GetMapping(value= {"/app"})
	public String helloGradleApp() {
		return "Hello Gradle Application!";
	}

}
