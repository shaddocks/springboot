package com.spring.study.AOP;

import com.spring.study.config.JavaConfig;
import com.spring.study.controller.UserController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {

    ApplicationContext context;

    @Before
    public void testBefore() {
        context = new AnnotationConfigApplicationContext(JavaConfig.class);
    }

    //aop
    @Test
    public void test01() {
        UserController userController = context.getBean(UserController.class);
        System.out.println(userController.getUser());
    }


    @After
    public void testAfter() {
        ((AnnotationConfigApplicationContext) context).close();
    }
}
