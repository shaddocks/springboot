package com.spring.study.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;

@Lazy
public class Partner implements InitializingBean, DisposableBean {

    String name;
    Integer age;
    String gender;

    public Partner() {
    }

    public Partner(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("partner will been destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("partner has been created");
    }

    @Override
    public String toString() {
        return "Partner{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
