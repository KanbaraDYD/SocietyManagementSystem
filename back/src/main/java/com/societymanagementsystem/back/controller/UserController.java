package com.societymanagementsystem.back.controller;

import com.societymanagementsystem.back.entity.code;
import com.societymanagementsystem.back.entity.user;
import com.societymanagementsystem.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserService service;

    @PostMapping("/login")
    public code login(@RequestBody user user)
    {
        user u = service.getUserByName(user.getUsername()); //根据用户名查询
        code code = new code();
        if(u == null) //用户名不存在
        {
            code.setCode(401);
            return code;
        }
        else //用户名存在
        {
            if(u.getPassword().equals(user.getPassword())) //密码正确
            {
                code.setCode(200);
                code.setId(u.getId());
                return code;
            }
            else //密码错误
            {
                code.setCode(400);
                return code;
            }
        }
    }

    @PostMapping("/sign")
    public code sign(@RequestBody user user)
    {
        user u = service.getUserByName(user.getUsername()); //根据用户名查询
        code code = new code();
        if(u == null)
        {
            user.setMark("NULL");
            service.sign(user);
            code.setCode(200);
            return code;
        }
        else
        {
            code.setCode(400);
            return code;
        }
    }

    @GetMapping("/getUserById")
    public user getUserById(int id)
    {
        return service.getUserById(id);
    }
}
