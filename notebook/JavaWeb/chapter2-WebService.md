# 第二章-web服务器

## 2.1 技术讲解
ASP: 在HTML中嵌入了VB的脚本，ASP+COM。在ASP开发中，基本一个页面都有几千行的业务代码，页面及其混乱。

PHP: 开发速度快，功能强大，跨平台，代码简单，但无法承载大访问量。

JSP/servlet: 基于Java的B/S架构，可以承载三高问题带来的影响。

## 2.2 web服务器
服务器是一种被动的操作，用来处理用户的一些请求和给用户一些响应信息。 如Tomcat、IIS(windows系统下的web服务器)等。

Tomcat实际上运行JSP页面和Servlet。另外，Tomcat具有处理HTML页面的功能，另外它还是一个Servlet和JSP
容器，独立的Servlet容器是Tomcat的默认模式。

## 2.3 Tomcat
### 2.3.1 下载-解压
没什么好说的

### 2.3.2 启动
- bin: 启动，关闭的脚本文件
- conf: 一些配置文件
- lib: 依赖的jar包
- logs: 日志文件
- temp: 临时文件夹
- webapps: 存放网站的目录
- work: 无

双击startup.bat，访问localhost:8080即可。直接叉掉程序即可关闭/或shutdown.bat。

可能遇到的问题
- Java环境没有配置
- 闪退问题，需要配置兼容性
- 乱码问题，配置文件中设置2

## 2.3.3 配置
在tomcat文件夹下conf中的server.xml配置文件中:
- 可以配置启动的端口号, Connector port="8085"
- 可以配置主机的名称, 默认的主机名: Host name="localhost"=127.0.0.1
- 默认的网站存放位置, webapps, appBase="webapps"

server.xml文件中重点配置信息说明:
- \<Server>元素: <Server port="8005" shutdown="SHUTDOWN">, 其中port表示服务器接收shutdown命令的地址，默认localhost。
- \<Connector>元素: \<Connector port="8080" protocol="HTTP/1.1" maxHttpHeaderSize="409600" connectionTimeout="20000" redirectPort="8443" />
port表示绑定的端口，默认8080
- \<host>元素: \<Host name="localhost" appBase="webapps" unpackWARs="true" autoDeploy="true">
, 其中name属性，是域名名称，tomcat会将其全部转化为小写，如果设置的是*.baidu.com，那么你将匹配www.baidu.com或
admin.baidu.com等等以baidu.com结尾的域名。那么只有是符合该域名的条件才会被接受;
appBase指的是虚拟主机的应用程序目录，可以是绝对路径，也可以是相对于tomcat目录的相对路径，如果未指定
将使用默认值webapps。

在windows系统下System32/drivers/etc/hosts文件中有域名解析

## 2.3.4 发布一个网站
1. 将自己写的网站放到服务器(tomcat)中指定的web应用的文件夹(webapps)下
2. 网站应有的结构
>--webapps: tomcat服务器的web目录
> 
>----ROOT: 自带的网站
> 
>----name: 网站的目录名
> 
>------index.html 默认的首页 (访问网站目录名时，会默认访问这个，如果没有则404)
> 
>------static(css, js, img...): 静态资源
> 
>------WEB-INF: 
> 
>--------classes: Java程序
> 
>--------lib: web应用所依赖的jar包
> 
>--------web.xml: 网站的配置文件