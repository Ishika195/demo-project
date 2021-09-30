package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {
	ArrayList<Account> accounts = new ArrayList<Account>();

	@GetMapping("/")
	void getAccounts() {
		System.out.println("called");
	}

	@GetMapping("/{name}")
    Account getAccount(@PathVariable String name) {
		for(Account account: accounts) {
			if(account.getName().equals(name)) {
				return account;
			}
		}
		System.out.println("Account not found");
		return null;
	}

	@PostMapping
	String postAccount(@RequestBody Account account) {
		System.out.println("called");
		System.out.println("Name : " + account.getName());
		System.out.println("Account Number: " + account.getAccNo());
		System.out.println("Address : " + account.getAddress());
		System.out.println("Available Balance : " + account.getBalance());
		System.out.println("Date of Creation : " + account.getDate());
		System.out.println("Account Status : " + account.getStatus());
		accounts.add(account);
		return "Account details displayed";
	}
}
