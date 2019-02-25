package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repo;

	@GetMapping("users")
	public List<UserModel> getUsers() {
		return repo.findAll();
	}

	@GetMapping("user/{id}")
	public Optional<UserModel> getUserById(@PathVariable int id) {
		return repo.findById(id);
	}
	
	@GetMapping("user/name/{name}")
	public Optional<UserModel> getUserByName(@PathVariable String name) {
		return repo.findByName(name);
	}
	
	@GetMapping("user/age/{age}")
	public Optional<UserModel> getUserByAge(@PathVariable int age) {
		return repo.findByAge(age);
	}
	
	@PostMapping("add")
	public void addUser(@RequestBody UserModel user) {
		repo.save(user);
	}
	
	@PutMapping("update")
	public void updateUser(@RequestBody UserModel user) {
		repo.save(user);
	}
	
	@DeleteMapping("delete")
	public void deleteUsers() {
		repo.deleteAll();
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteUser(@PathVariable int id) {
		repo.deleteById(id);
	}
}
