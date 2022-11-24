package com.spring.study.dao.impl;

import com.spring.study.bean.User;
import com.spring.study.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Value("${mysql.username}")
    public String name;


    @Override
    public User getUser() {
        User user = new User();
        user.setName(name);
        return user;
    }
}
