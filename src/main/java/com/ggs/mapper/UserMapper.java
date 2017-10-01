package com.ggs.mapper;

import com.ggs.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Results(id = "userResultMapper", value ={
            @Result(property = "id", column = "ID"),
            @Result(property = "username", column = "USER_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "type", column = "TYPE"),
            @Result(property = "firstName", column = "FIRST_NAME"),
            @Result(property = "lastName", column = "LAST_NAME"),
            @Result(property = "dob", column = "DOB"),
            @Result(property = "email", column = "EMAIL"),
            @Result(property = "mobile", column = "MOBILE"),
            @Result(property = "address", column = "ADDRESS"),
    })
    @Select("SELECT * FROM USER WHERE ID= #{ID}")
    User findUserById(@Param("ID") String id);


    @ResultMap("userResultMapper")
    @Select("SELECT * FROM USER WHERE USER_NAME= #{USER_NAME}")
    User findUserByUsername(@Param("USER_NAME") String username);

    @ResultMap("userResultMapper")
    @Select("SELECT * FROM USER")
    List<User> findAll();

}