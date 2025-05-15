package com.example.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.taskmanager.model.entity.*;

@SpringBootApplication
@RestController
public class TaskManagerApplication {
	
	@Autowired
	User user;
	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
		//User user = new User(1L, "bolsonaro", "123321");
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}
