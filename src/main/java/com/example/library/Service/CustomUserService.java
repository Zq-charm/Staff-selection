package com.example.library.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.library.Entity.CustomUserDetails;
import com.example.library.Entity.User;
import com.example.library.Repository.UserRepository;
@Component
public class CustomUserService implements UserDetailsService
{

	  @Autowired
	    private UserService userService;

	    /**
	     * 认证过程中 - 根据登录信息获取用户详细信息
	     *
	     * @param username 登录用户输入的用户名
	     * @return
	     * @throws UsernameNotFoundException
	     */
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        //根据用户输入的用户信息，查询数据库中已注册用户信息
	        User user = userService.findUserByUserName(username);
	        //如果用户不存在直接抛出UsernameNotFoundException异常
	        if (user == null) throw new UsernameNotFoundException("用户名为" + username + "的用户不存在");
	        return new CustomUserDetails(user);
	    }
}
