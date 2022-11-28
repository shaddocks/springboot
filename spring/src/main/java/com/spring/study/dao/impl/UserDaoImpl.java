package com.spring.study.dao.impl;

import com.spring.study.bean.User;
import com.spring.study.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    @Value("${mysql.username}")
    public String name;


    @Override
    public User getUser() {
        User user = new User();
        user.setName(name);
        //throw new RuntimeException("error");
        return user;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, timeout = 2)
    public void translate() {
        sub();
        save();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void sub() {
        //扣钱
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save() {
        //存钱
    }
}
