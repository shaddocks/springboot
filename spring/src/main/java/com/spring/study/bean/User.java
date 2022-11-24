package com.spring.study.bean;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

@DependsOn("partner")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class User {

    String name;
    Integer age;
    String gender;
    List<String> hobbies;
    Map<String, String> grades;
    Partner partner;

    public User() {
    }

    public User(String name, Integer age, String gender, List<String> hobbies, Map<String, String> grades, Partner partner) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;
        this.grades = grades;
        this.partner = partner;
    }

    /*
    注解失效
     */
    @PostConstruct
    public void afterInit() {
        System.out.println("user has been created");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("user will be destroyed");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", hobbies=" + hobbies +
                ", grades=" + grades +
                ", partner=" + partner +
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

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, String> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, String> grades) {
        this.grades = grades;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
