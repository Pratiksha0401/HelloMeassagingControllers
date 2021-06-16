package com.example.HelloWorldControllers.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HelloWorldControllers.UserModel.User;

@RestController
@RequestMapping("/hello")
public class HelloMessaging {
	
	/*  (command: curl -X GET "http://localhost:8080/hello/home" -w "\n")
    	( url:     http://localhost:8080/hello/home) */
	@RequestMapping(value = {"","/","/home"})
	public String sayHello() {
		return "Hello From BridgeLabz !";
	}
	
	/* 	(command: curl "http://localhost:8080/hello/query?name=Pratiksha" -w "\n")
    	( url:     http://localhost:8080/hello/query?name=Pratiksha) */
	@RequestMapping(value = {"/query"}, method = RequestMethod.GET)
	public String sayHello(@RequestParam(value="name")String name) {
	return "Hello " + name + " !!";
	}
	
	/* 	(command: curl  "http://localhost:8080/hello/param/Pratiksha" -w "\n" )
    	(url:     http://localhost:8080/hello/param/Pratiksha ) */
	@GetMapping ("/param/{name}")
	public String sayHelloParam(@PathVariable String name) {
	return "Hello " + name + " !!"; 
	}
	
	/* 	(command: curl -X POST -H "Content-Type:application/json" -d '{"firstName":"Pratiksha","lastName":"Nagoshe"}' "http://localhost:8080/hello/post" -w "\n" )
    	(url:     http://localhost:8080/hello/post ) */
	@PostMapping ("/post")
	public String sayHello(@RequestBody User user) {
	return "  Hello " + user.getFirstName() + " "+ user.getLastName() +" !!"; 
	}
	
	/* curl -X PUT "http://localhost:8080/hello/put/Pratiksha/?lastName=Nagoshe" -w "\n" */
	@PutMapping("/put/{firstName}")
	public String sayHello(@PathVariable String firstName,
			               @RequestParam(value="lastName") String lastName) {
		return " Hello " + firstName +" "+ lastName + " !!";
	}
}
