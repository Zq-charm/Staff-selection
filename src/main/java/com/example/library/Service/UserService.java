package com.example.library.Service;

import java.util.List;

import com.example.library.Entity.Expert;
import com.example.library.Entity.User;

public interface UserService {

	 public List<User> usersList();
	 
	 public User findUserById(Long id);
	 
	 public User findUserByUserName(String userName);
	 
	 public User addOneUser(User user);
	 
	 public User updateOneUser(User user);
	 
	 public void deleteOneUser(Long id);
}
