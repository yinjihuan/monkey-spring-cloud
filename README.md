现在提起 Spring Cloud 我相信你就算没自己体验过，也肯定听说过。作为微服务架构的主流选择，如果你是一名 Java 使用者和爱好者，我相信你对 Spring Cloud 肯定感兴趣，对今天这门课程更加感兴趣。

很多人看文档，看书，将一些组件都用了，但是由于实际工作中的种种原因，无法真正的去使用 Spring Cloud 来进行开发，就会出现只知道各个组件的使用，对于怎么整合这些组件来一个完整的微服务架构比较迷茫。

我打算在后面的时间里给大家录制一套从前端到后端的课程，既能让大家将 Spring Cloud 用起来，也能让大家清楚的了解在微服务架构下，前后端的交互方式。

本套课程适合已经对 Spring Cloud 有一定了解的朋友，因为本套课程主要是讲一个完整的开发流程和框架的整合，并不会讲一些组件比较基础的内容，如果你没接触过 Spring Cloud, 我推荐你买本书学习下，正好我之前写了一本，购买链接: [https://item.jd.com/12404630.html](https://item.jd.com/12404630.html)

主要的课程大纲列在下面了，后面只会多不会少，也许会再录制过程中加内容，也许会调整顺序，但是总的内容肯定是包含下面的。

课程具体什么时候更新完这个也不一定，但我一有时间就会更新，不会让大家等太久，本套课程用比较稳定的Spring Cloud Finchley.SR2 版本 + Spring Boot 2.0.6.RELEASE 进行讲解。

我这边所有的课程都可以学习，前提你是我星球的球友才行。加入星球扫码文章末尾的海报即可，加入后对本套课程感兴趣的朋友可以加我微信：jihuan900 备注 Spring Cloud

# 课程学习地址：[http://cxytiandi.com/course/25](http://cxytiandi.com/course/25)

画了一张比较简单的架构图，我们这套课程也是按照这个来学习的。

![架构图](https://upload-images.jianshu.io/upload_images/2685774-cce4a4dcd87d222c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


# 1. 准备工作

- 课程介绍
- 业务分析，服务划分
- 整体框架搭建
- 基础工具增加
- 全局异常处理
- 自定义异常处理
- 注解验证参数

# 2. 实战工作
- 搭建Eureka服务
- Eureka认证
- 获取用户信息接口编码
- 获取文章信息接口编码
- 整合Swagger
- Feign进行接口内部调用
- Hystrix在Feign中的使用
- Apollo集中管理配置

# 3. 前后端对接
- 搭建Zull服务
- Zull路由转发
- Zull异常处理
- Zull服务的回退
- 前端框架搭建
- 前端通过Zull调用接口

# 4. 认证实现
- 前端对接登陆
- 用户服务登陆编码
- Zull实现权限控制
- Zull传递用户信息到文章服务
- 文章服务传递用户信息到用户服务
- Jwt注销问题解决方案

# 5. 网关限流与灰度
- 常见的限流算法
- RateLimiter限流
- spring-cloud-zuul-ratelimit限流
- spring-cloud-zuul-ratelimit源码分析
- 灰度发布介绍
- Nepxion Discovery 灰度实战

# 6. 链路追踪与监控
- Sleuth的使用
- Sleuth手动埋点
- Spring Boot Admin介绍
- Spring Boot Admin使用
- Spring Boot Admin通知

# 7. 实践经验分享
- 本地开发服务复用
- 压测参数调优
- 前后端数据加解密

![微信扫码加入猿天地知识星球](https://upload-images.jianshu.io/upload_images/2685774-b11318670c1457fa.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
