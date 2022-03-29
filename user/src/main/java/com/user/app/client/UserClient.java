package com.user.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.app.entity.User;


@FeignClient("userservice")
public interface UserClient {
	
	 @GetMapping("/users")
	 public List<String> getAllUsers();
	 
	 @PostMapping("/users")
	 public ResponseEntity<String> saveUsersDetails(@RequestBody User user);
	 
	 @GetMapping("/users/{userId}")
	 public ResponseEntity<String> getUserById(@PathVariable Integer userId);
	 
	 
	 @GetMapping("/users/name")
	 public ResponseEntity<String> getUserByName(@RequestParam String username);
	

}
