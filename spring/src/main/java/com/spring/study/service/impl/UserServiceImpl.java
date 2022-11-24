package com.spring.study.service.impl;

import com.spring.study.bean.User;
import com.spring.study.dao.UserDao;
import com.spring.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser() {
        return userDao.getUser();
    }

}
