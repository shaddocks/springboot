此是在windows系统下开发的，若在其他环境开发，需修改一些操作，但大体操作相同。

网站是如何进行访问的
1. 输入一个域名，回车
2. 去检查本机的hosts配置文件，有无这个域名的映射，有，直接返回对应的IP地址; 无，去DNS服务器(域名服务器)找
   找到的话就返回，找不到就返回找不到。


web服务器的运行流程: 
客户端发起请求，由web服务器响应，若是静态资源，则直接访问文件系统;
若是动态资源，则请求Servlet/JSP，由其请求数据库数据等返回。
