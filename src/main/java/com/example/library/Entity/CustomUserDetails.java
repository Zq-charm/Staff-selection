package com.example.library.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 描述：自定义UserDetails，使UserDetails具有TUser的实体结构
 *
 * @Author shf
 * @Date 2019/4/19 10:30
 * @Version V1.0
 **/
public class CustomUserDetails extends User implements UserDetails {
    public CustomUserDetails(User user){
        if(null != user){
        	this.setUserId(user.getUserId());
        	this.setUserName(user.getUserName());
        	this.setPassWord(user.getPassWord());
        	this.setOrganization(user.getOrganization());
            this.setRole(user.getRole());
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getPassWord();
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getUserName();
	}
}