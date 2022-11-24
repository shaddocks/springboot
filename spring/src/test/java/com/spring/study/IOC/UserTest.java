package com.spring.study.IOC;

import com.alibaba.druid.pool.DruidDataSource;
import com.spring.study.bean.Partner;
import com.spring.study.bean.User;
import com.spring.study.config.JavaConfig;
import com.spring.study.controller.UserController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    ApplicationContext context;

    @Before
    public void testBefore() {
        //context = new ClassPathXmlApplicationContext("spring2.xml");
        context = new AnnotationConfigApplicationContext(JavaConfig.class);
    }

    //spring1.xml
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

    //spring2.xml
    @Test
    public void test03() {
        UserController bean = context.getBean(UserController.class);
        System.out.println(bean.getUser());
    }

    //JavaConfig.java
    @Test
    public void test04() {
        DruidDataSource bean = context.getBean(DruidDataSource.class);
        System.out.println(bean);
        UserController userController = context.getBean(UserController.class);
        System.out.println(userController.getUser());
    }


    @After
    public void testAfter() {
        //((ClassPathXmlApplicationContext) context).close();
        ((AnnotationConfigApplicationContext) context).close();
    }
}
