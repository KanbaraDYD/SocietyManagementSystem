package com.societymanagementsystem.back.service;

import com.societymanagementsystem.back.entity.user;

public interface UserService
{
    user getUserByName(String username);
    user getUserById(int id);
}
