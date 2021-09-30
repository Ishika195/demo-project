package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping("/")
	List<User> getUsers() {
		
		System.out.println("Called.....");
		return userService.getUsers();
	}
	@GetMapping("/{id}")
	void getUser(@PathVariable Integer id) {
		System.out.println("Called....."+id);
	}
	@PostMapping
	String saveUser(@RequestBody User user) {
		userService.save(user);
		System.out.println("Post request......");
		System.out.println("got user" + user.getName()+" aged "+ user.getAge());
		return "Post called";
	}
	@PutMapping
	String handlePutMapping() {
		System.out.println("Put request......");
		return "Put method called.";
	}
}
