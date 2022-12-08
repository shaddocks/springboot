# 启动web项目


# Servlet

## Servlet简介
- Servlet是Sun公司开发动态web的技术
- Sun在这些API中提供了一个接口叫做: Servlet, 如果想开发一个Servlet程序，只需完成两步:
  - 编写一个类，实现Servlet接口
  - 把开发好的Java类部署到web服务器中

<font color=red>把实现Servlet接口的程序叫做Servlet</font>。

## hello world
1. 创建一个普通maven项目，可右击add framework来添加web模块。
2. 关于maven父子工程的理解(父项目中的Java子项目可以直接使用):
    > 父项目会有\<modules>\<module>servlet\</module>\</modules>
    > 
    > 子项目会有\<parent>...\</parent>
3. Servlet程序编写: 写一个普通类并实现Servlet接口，直接继承HttpServlet
4. 重写doGet, doPost或service等方法。
5. 编写Servlet的映射(为什么需要映射? 写的是Java程序，但是通过浏览器访问，
而浏览器需要连接web服务器，所以需要在web服务中注册写的Servlet，还需要一个浏览器能访问的路径), 见web.xml文件.
6. 配置Tomcat: idea右上角选择edit configurations点击+号，选择Tomcat，配置即可。注意Server，Deployment和项目路径。
7. 启动测试。