package com.spring.study.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(value = {"com.spring.study"})
@PropertySource("classpath:user.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class JavaConfig {

    @Value("${mysql.username}")
    String userName;
    @Value("${mysql.password}")
    String password;
    @Value("${mysql.url}")
    String url;
    @Value("${mysql.driver}")
    String driver;
    @Value("${initialSize}")
    Integer initialSize;
    @Value("${maxActive}")
    Integer maxActive;


    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
        return jdbcTemplate;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DruidDataSource druidDataSource){
        return new NamedParameterJdbcTemplate(druidDataSource);
    }

    //配置事务管理器的bean
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource){
        return new DataSourceTransactionManager(druidDataSource);
    }
}
