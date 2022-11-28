package com.spring.study.transaction;

import com.spring.study.bean.Employee;
import com.spring.study.config.JavaConfig;
import com.spring.study.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


/*@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JavaConfig.class)*/
@SpringJUnitConfig(JavaConfig.class)
public class Junit5 {

    @Autowired
    UserController userController;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //测试整合junit5
    @Test
    public void test01() {
        System.out.println(userController.getUser());
    }

    //JdbcTemplate
    @Test
    void test02() {
        Long query = jdbcTemplate.queryForObject("select count(*) from employees", Long.class);
        System.out.println(query);
    }

    @Test
    void test03() {
        //数据名和字段名一致，可直接使用new BeanPropertyRowMapper<>(User.class)
        //若不一致
        Employee query = jdbcTemplate.queryForObject("select * from employees where employee_id = 100", (resultSet, i) -> {
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt("employee_id"));
            return employee;
        });
        System.out.println(query);
    }

    @Test
    void test04() {
        List<Employee> employees = jdbcTemplate.query("select * from employees where employee_id = 100 or employee_id = 101", ((resultSet, i) -> {
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt("employee_id"));
            return employee;
        }));
        employees.forEach(System.out::println);
    }

    @Test
    void test05() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        namedParameterJdbcTemplate.update("delete from t_user where id=:id", map);
    }

    //properties属性资源文件读取
    @Test
    void test11() throws Exception{
        Properties properties = new Properties();
        properties.load(new BufferedInputStream(new FileInputStream("src\\main\\resources\\user.properties")));
        System.out.println(properties.getProperty("mysql.username"));
    }

    @Test
    void test12() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("property\\abc.properties");
        assert inputStream != null;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Properties properties = new Properties();
        properties.load(bufferedReader);
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        System.out.println(properties.size());
    }
}
