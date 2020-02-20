package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})

public class DemoApplication implements ErrorController {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	private static final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error() {
		return "redirect:/";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}
