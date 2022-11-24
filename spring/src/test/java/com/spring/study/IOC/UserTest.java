package com.spring.study.IOC;

import com.spring.study.bean.Partner;
import com.spring.study.bean.User;
import com.spring.study.controller.UserController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    ApplicationContext context;

    @Before
    public void testBefore() {
        context = new ClassPathXmlApplicationContext("spring2.xml");
    }

    //spring1
    @Test
    public void test01() {
        Partner bean = context.getBean(Partner.class);
        System.out.println(bean);
    }

    @Test
    public void test02() {
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }

    //spring2
    @Test
    public void test03() {
        UserController bean = context.getBean(UserController.class);
        System.out.println(bean.getUser());
    }


    @After
    public void testAfter() {
        ((ClassPathXmlApplicationContext) context).close();
    }
}
