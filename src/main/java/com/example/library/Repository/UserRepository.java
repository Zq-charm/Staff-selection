package com.example.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.library.Entity.Expert;
import com.example.library.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User>{

	public User findUserByUserId(Long userId);
	public User findUserByUserName(String userName);
}
