package com.rxqp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.rxqp.entity.bo.User;

public interface UserMapper {
	@Select("select * from user where name = #{name}")
    public List<User> likeName(String name);
   
    @Select("select *from user where id = #{id}")
    public User getById(long id);
   
    @Select("select name from user where id = #{id}")
    public String getNameById(long id);
}
