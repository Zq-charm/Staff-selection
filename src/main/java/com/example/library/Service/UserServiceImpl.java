package com.example.library.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.Entity.Expert;
import com.example.library.Entity.User;
import com.example.library.Repository.ExpertRepository;
import com.example.library.Repository.UserRepository;


@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

	@Override
	public List<User> usersList() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findUserByUserId(id);

	}

	@Override
	public User addOneUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateOneUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteOneUser(Long id) {
		userRepository.deleteById(id);;
		
	}

	@Override
	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUserName(userName);
	}

}
