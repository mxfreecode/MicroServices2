package com.user.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.user.app.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public abstract ArrayList<User> findByUsername(String username);
	
	List<User> findByUsernameAndPassword(String username, String password);
	
}
