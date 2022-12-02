# HTTP

## 什么是http
HTTP(超文本传输协议)是一个简单的请求-响应协议，它通常运行在TCP之上。它指定了客户端可能发送给服务器什么样的消息以及得到
什么样的响应。请求和响应消息的头以ASCII码形式给出。
- 文本: html, 字符串, ...
- 超文本: 图片，音乐。视频，定位等。
- http: 80
- https: 443


## 两个时代
http1.0(HTTP/1.0), 客户端可以与web服务器连接，只能获得一个web资源，断开连接。

http2.0(HTTP/1.1), 客户端可以与web服务器连接，可以获得多个web资源。

## http请求
客户端-发请求(Reuqest)-服务器

以百度为例

General(请求和响应都有的):
>Request URL: https://www.baidu.com/ 请求地址
> 
>Request Method: GET方法/POST方法
> 
>Status Code: 200 OK 状态码: 200
> 
>Remote Address: 220.181.38.149:443 远程IP地址:端口
> 
>Referrer Policy: strict-origin-when-cross-origin

Request Headers:
> Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
> 
> Accept-Encoding: gzip, deflate, br
> 
> Accept-Language: zh-CN,zh;q=0.9 语言
> 
> Connection: keep-alive
> 
> Cookie: BIDUPSID=D8F4BE24C15F3A888CED4BDD5E3656CB; PSTM=1625043594; __yjs_duid=1_2ef9cf0616a3327d9074894344fa5b941626426741265; BAIDUID=C87C79F62C23AD12C1F1B9CF5C6EA1FF:FG=1; H_WISE_SIDS_BFESS=107314_110085_127969_131862_164870_175668_179348_179620_180276_181489_181589_181730_182235_182530_183031_183328_184042_184441_185239_185268_185636_185879_186317_186595_186635_186716_186843_187061_187085_187432_187447_187820_187929_188155_188182_188331_188713_188730_188749_188844_188874_189090_189178_189446_189679_189722_189731_189755_189756_189926_190112_190188_190461_190465_190473_190514_190652_190680_190684_190722_190737_190757_190790_190944_191067_191249_191286_191287_191370_191416_191454_191503_191527_191848_192018_192052_192154; BD_UPN=12314753; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BAIDUID_BFESS=C87C79F62C23AD12C1F1B9CF5C6EA1FF:FG=1; SL_G_WPT_TO=zh; SL_GWPT_Show_Hide_tmp=1; SL_wptGlobTipTmp=1; ZD_ENTRY=baidu; BD_HOME=1; delPer=0; BD_CK_SAM=1; BA_HECTOR=2g85a1a184ah8l810181apr91hohgfg1g; ZFY=zHZkZQgsK6HWi0cesPpV:AkxFh8PDfVW5hS7Fjy2uzvY:C; H_PS_PSSID=36551_37490_37833_37840_37871_37766_37813_37798_37758_26350_37478_37788; PSINO=3; H_PS_645EC=6075bcb5uiB%2BI06AIB68toQMpvt%2FguSfVCYi5KaRoP2nexa2yMKjqxD%2B9TQ; BDSVRTM=0
> 
> Host: www.baidu.com
> 
> sec-ch-ua: "Chromium";v="106", "Google Chrome";v="106", "Not;A=Brand";v="99"
> 
> sec-ch-ua-mobile: ?0
> 
> sec-ch-ua-platform: "Windows"
> 
> Sec-Fetch-Dest: document
> 
> Sec-Fetch-Mode: navigate
> 
> Sec-Fetch-Site: none
> 
> Sec-Fetch-User: ?1
> 
> Upgrade-Insecure-Requests: 1
> 
> User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36

1. 请求行
   - 请求行中的请求方式: GET
   - 请求方式: GET, POST, HEAD, DELETE...
     - GET: 请求能过携带的参数比较少，大小有限制，会在浏览器的URL地址栏显示数据内容，不安全，但高效。(参数放在URL后，以?分割URL和参数数据,参数之间以&相连)
     - POST: 请求能过携带的参数没有限制，大小没有限制，不会在浏览器的URL地址栏显示数据内容，安全但不高效。(提交的数据放在HTTP包的请求体中)
2. 消息头
   - accept: 告诉浏览器，它所支持的数据类型
   - accept-Encoding: 支持哪种编码格式 GBK UTF-8 ISO8859-1
   - accept-Language: 告诉浏览器，它的语言环境
   - Cache-Control: 缓存控制
   - Connection: 告诉浏览器，请求完成是断开还是保持连接。
   - Host: 主机

## http响应
服务器-响应-客户端

以百度为例

Response Headers: 

> Bdpagetype: 1
> 
> Bdqid: 0xbf2d105e00001d49
> 
> Connection: keep-alive 连接
> 
> Content-Encoding: gzip 编码
> 
> Content-Type: text/html; charset=utf-8 类型
> 
> Date: Fri, 02 Dec 2022 07:21:45 GMT
> 
> Server: BWS/1.1
> 
> Set-Cookie: BDSVRTM=0; path=/
> 
> Set-Cookie: BD_HOME=1; path=/
> 
> Set-Cookie: H_PS_PSSID=36551_37490_37833_37840_37871_37766_37813_37798_37758_26350_37478_37788; path=/; domain=.baidu.com
> 
> Strict-Transport-Security: max-age=172800
> 
> Traceid: 1669965705062356762613775684831109193033
> 
> Transfer-Encoding: chunked
> 
> X-Frame-Options: sameorigin
> 
> X-Ua-Compatible: IE=Edge,chrome=1

1. 响应体
   - accept: 告诉浏览器，它所支持的数据类型
   - accept-Encoding: 支持哪种编码格式 GBK UTF-8 ISO8859-1
   - accept-Language: 告诉浏览器，它的语言环境
   - Cache-Control: 缓存控制
   - Connection: 告诉浏览器，请求完成是断开还是保持连接。
   - Host: 主机
   - Refresh: 告诉客户端，多久刷新一次
   - Location: 让网页重定向
2. 响应状态码
   - 200: 请求响应成功
   - 3xx: 请求重定向(重新到给的新位置去)
   - 4xx: 找不到资源 404
   - 5xx: 服务器代码错误 500 502(网关错误)

当浏览器地址栏输入地址并回车的一瞬间到页面能展示回来，经历了什么?

答: 

1. (域名解析）在客户端，浏览器输入地址后，首先会在windows系统文件的hosts中查找是否有对应的ip地址，如果没有则需要向DNS域名解析服务器询问该域名对应的ip地址。
2. 获取相应的IP地址后，建立TCP连接，TCP三次握手。
第一次握手：客户端发送SYN（同步序列编号）包（seq=x)到服务器，并进入SYN-SENT状态，等待服务器的确认
第二次握手：服务器收到了SYN包为了确认客户端的SYN所以发送一个ACK（ack=x+1,已经收到序列号为j的数据包准备接受序列号为j+1的),同时自己也发送一个SYN包（seq=y,服务器的初始序列号)，此时服务器进入了SYN-RECV状态。
第三次握手：客户端收到服务端的SYN+ACK包，向服务器发送确认包ACK(ack=y+1 seq=x+1)，这个包发送完毕客户端和服务端进入ESTABLISHED状态，连接建立成功。
seq:用来标识在TCP发端到TCP收端发送的数据字节流，他表示在这个报文段中的第一个数据字节在数据流中的序号
ack:期待收到的下一个序号，一般是上次已经收到的字节加1.
3. （建立起TCP连接后发起http请求）客户端向服务器端发送请求，包含请求行，请求头。主要的两种请求方式（GET与POST）
-->GET:请求能够携带的参数比较少，大小有限制，会在浏览器的URL地址栏显示数据的内容，不安全，但高效。
-->POST:请求能够携带的参数没有限制，大小没有限制，不会在浏览器的URL地址栏显示数据内容，安全，但不高效。
4. （服务器响应http请求）服务器处理请求，并返回响应，包含状态码，响应头，响应体。
5. （浏览器解析http代码）浏览器收到响应，解析http代码渲染页面，并在浏览器页面展示出来。

6.（断开连接）http1.0短连接，http1.1长连接。


## 补充

### URL统一资源定位符
统一资源定位符是对可以从互联网上得到的资源的位置和访问方法的一种简洁的表示，是互联网上标准资源的地址。互联网上的每个文件都有一个唯一的URL，它包含的信息指出文件的位置以及浏览器应该怎么处理它。

### HTTP协议简介
HTTP协议是超文本传输协议。用于服务器和本地浏览器之间传输超文本的传输协议。

HTTP是一个属于应用层的面向对象的协议。HTTP协议工作于客户端-服务器端架构上，浏览器作为HTTP客户端通过URL向HTTP服务器端即web
服务器发送所有请求。web服务器根据接收到的请求后，向客户端发送响应信息。

使用HTTP协议，每当有新的请求发送时，就会有对应的新响应产生。协议本身并不保留之前一切的请求或响应报文的信息。这是为了
更快地处理大量事务，确保协议的可收缩性，而特意把http协议设计成如此简单的。但随着web发展，如需要保持登陆状态，
为了网站能够掌握是谁发出的请求，需要保存用户的状态。HTTP/1.1虽然是无状态协议，但是为了满足该需求，引入了cookie技术。

综上，HTTP协议规定了浏览器与服务器端之间数据交互的格式，如果服务器端不遵守协议，需使用对应的客户端访问。

### HTTP协议的四大特性
1. 基于TCP/IP协议之上的应用层协议
2. 基于请求-响应模式(HTTP协议规定请求从客户端发出，最后由服务器端响应客户端请求并返回)
3. 无状态保存: 不保存用户信息状态(HTTP协议自身不对请求和响应之间的通信状态进行保存，即在HTTP这个级别，协议对于发送过的请求或响应都不做持久化处理; 使用HTTP协议，每当新的请求发送，就会有对应的新响应产生)
4. 无(短)连接: 无连接的含义是限制每次连接只处理一个请求。服务器处理完客户的请求，并收到客户的应答后，即断开连接。即: 客户端请求一次服务器端就响应一次，
之后就没有任何关系(之后可以用websocket实现长连接，可以让双方建立连接后默认不断开连接，如QQ)。

### 报文介绍
1. HTTP报文: 用于http协议交互的消息叫做http报文。报文本身是由多行数据构成的字符串文字。http报文通常由报文首部和报文主体两部分组成，
两者之间由最初出现的空行划分。报文首部(在客户端和服务器端处理时起着至关重要的信息)和报文主体(所有需要的用户和资源信息)。
2. 请求报文: 客户端发出的报文叫做请求报文，其报文首部+报文主体的结构如下:
   1. 请求行: 包含了客户端的请求方法，URL，HTTP版本
   2. 请求首部字段: 包括了请求的附加信息如客户端的信息，响应的优先级
   3. 通用首部字段: 请求报文和响应报文都会使用的报文
   4. 实体首部字段: 补充了与实体相关的资源信息，如实体更新的时间
   5. 报文主体: 一般来说请求报文在使用GET方法的时候没有请求报文，在使用POST方法的时候才有
3. 响应报文: 服务器端发出的报文叫做响应报文，结构如下:
   1. 响应报文状态行: 包括HTTP版本，状态码
   2. 响应报文首部字段: 服务器端向客户端发送响应报文使用的首部包括相应的附加内容，要求客户端补充的消息等。
   3. 通用首部字段: 请求报文和响应报文都会使用的报文
   4. 实体首部字段: 补充了与实体有关的资源信息，如实体更新时间
   5. 报文主体: 对于响应报文来说报文体一般是传给客户端的数据

### 客户端向服务器请求的HTTP方法
1. GET: 获取资源。客户端:"我想要你的某个资源“->GET->服务器端:"某个资源”
2. POST: 传输实体主体。客户端:"我先把这条数据给你，你再帮我处理一下"->POST->服务器端:"处理数据后的结果"
3. PUT: 传输文件。客户端:"我传个文件给你"->PUT
4. HEAD: 获取报文首部。HEAD方法和GET方法一样都是从服务器端获取资源，只是HEAD方法获取的是报文首部，用来确定客户端输入的URL的有效性和资源更新的日期时间。客户端:"告诉我那个的报文首部啊"->HEAD->服务器端
5. DELETE: 删除文件。客户端:"赶紧把那份文件删掉"->DELETE->服务器端:"马上删"
6. OPTION: 询问支持的方法。客户端用来询问服务器端支持哪一些方法。客户端:"你支持哪一些方法啊"->OPTION->服务器端:"我支持POST, GET,...”