package com.example.library.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Entity.Expert;
import com.example.library.Entity.User;
import com.example.library.Service.ExpertService;
import com.example.library.Service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    
    //查询用户列表
    @GetMapping(value = "/users")
    public List<User> usersList()
    {
        return userService.usersList();
    }
    

    //查询一个用户
    @GetMapping(value = "/users/{id}")
    public User userFindOne(@PathVariable("id") Long id)
    {

        return userService.findUserById(id);//.orElse(null)
    }

    
    //添加一个用户
    @PostMapping(value = "/users")
    @ResponseBody
    public User userAdd( @RequestBody @Valid User user)
    {
        return userService.addOneUser(user);
    }


    //更新一个专家
    @PutMapping(value = "/users/{id}") //Expert需要传主键
    @ResponseBody
    public User userUpdate(@PathVariable("id") Long user_id, @RequestBody @Valid User user)
    {
    	
        return userService.updateOneUser(user);
    }

    //删除一个专家
    @DeleteMapping(value = "/users/{id}")
    public void userdelet(@PathVariable("id") Long id)
    {
    	userService.deleteOneUser(id);
    }
}
