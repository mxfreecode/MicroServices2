package com.user.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.dto.LoginRequestDTO;
import com.user.app.dto.ResponseDTO;
import com.user.app.entity.User;
import com.user.app.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping()
	public ArrayList<User> getUsers(){
		return userService.getUsers();
	}
	
	@PostMapping()
	public User saveUser(@RequestBody User user) {
		return this.userService.saveUsers(user);
	}

    @GetMapping( path = "/{userId}")
    public Optional<User> getUsersById(@PathVariable("userId") Integer userId) {
        return this.userService.getById(userId);
    }
    
    @GetMapping("/query")
    public ArrayList<User> getUserByUsername(@RequestParam("username") String username){
        return this.userService.getByUsername(username);
    } 
    
    @DeleteMapping( path = "/{userId}")
    public String deleteById(@PathVariable("userId") Integer userId){
        boolean ok = this.userService.deleteUser(userId);
        if (ok){
            return "Delete User Successful id:" + userId;
        }else{
            return "Cannot Deleted User:" + userId;
        }
    }
    
    ////LOGIN 
	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
		ResponseDTO responseDTO =  userService.login(loginRequestDTO);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
    
    
    
}






