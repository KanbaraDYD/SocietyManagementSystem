package com.societymanagementsystem.back.mapper;

import com.societymanagementsystem.back.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper
{
    @Select(value="SELECT * FROM USER WHERE USERNAME = #{username}")
    user getUserByName(@Param(value = "username") String username);

    @Select(value="SELECT * FROM USER WHERE ID = #{id}")
    user getUserById(@Param(value = "id")int id);
}
