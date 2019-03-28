package com.example.loginSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginSystem.model.LoginUser;
import com.example.loginSystem.repository.LoginUserRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginUserController {

	@Autowired
	LoginUserRepository loginUserRepository;

	@GetMapping("/getAll")
	public List<LoginUser> getAll() {
		System.out.print(loginUserRepository.findAll());
		return loginUserRepository.findAll();
	}

	// Search User
	@PostMapping("/getUser")
	public LoginUser login(@RequestParam String email, @RequestParam String password) {
		return loginUserRepository.findByEmailAndPassword(email, password);
	}

	// Create a new user
	@PostMapping("/createUser")
	public LoginUser createUser(@Valid @RequestBody LoginUser registedUser) {
		return (loginUserRepository.checkIfEmailAlreadyExist(registedUser.getEmail()) == null)
				? loginUserRepository.save(registedUser)
				: null;
	}
}
