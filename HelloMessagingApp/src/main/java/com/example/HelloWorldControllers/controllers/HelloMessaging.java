package com.example.HelloWorldControllers.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
