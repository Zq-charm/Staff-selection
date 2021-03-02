package com.example.library.utils;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.library.Entity.User;

/**
 * 描述：
 *
获取当前用户的信息。这个类就是一个静态工具类。
 * @Version V1.0
 **/
public class UserHolder {
    public static User getUserDetail(){
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        User user = (User) auth.getPrincipal();
        return user;
    }
//    public static String getUserCode(){
//        SecurityContext ctx = SecurityContextHolder.getContext();
//        Authentication auth = ctx.getAuthentication();
//        User user = (User) auth.getPrincipal();
//        return user.getCode();
//    }
//    public static int getUserId(){
//        SecurityContext ctx = SecurityContextHolder.getContext();
//        Authentication auth = ctx.getAuthentication();
//        User user = (User) auth.getPrincipal();
//        return user.getId();
  //  }
}