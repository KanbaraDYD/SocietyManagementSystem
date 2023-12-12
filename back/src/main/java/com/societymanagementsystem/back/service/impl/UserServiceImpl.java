package com.societymanagementsystem.back.service.impl;

import com.societymanagementsystem.back.entity.user;
import com.societymanagementsystem.back.mapper.UserMapper;
import com.societymanagementsystem.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserMapper mapper;

    @Override
    public user getUserByName(String username)
    {
        return mapper.getUserByName(username);
    }

    @Override
    public user getUserById(int id)
    {
        return mapper.getUserById(id);
    }
}
