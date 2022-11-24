package com.spring.study.feature;

import com.spring.study.bean.User;
import com.spring.study.config.JavaConfig;
import com.spring.study.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


/*@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JavaConfig.class)*/
@SpringJUnitConfig(JavaConfig.class)
public class Junit5 {

    @Autowired
    UserController userController;

    @Test
    public void test01() {
        System.out.println(userController.getUser());
    }


    //新特性
    //函数式风格注册对象
    public void test100() {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        applicationContext.refresh();
        applicationContext.registerBean("user", User.class, User::new);
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean);
    }


}
