package com.societymanagementsystem.back.entity;

import lombok.Data;

@Data
public class user
{
    private int id;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String mark;
}
