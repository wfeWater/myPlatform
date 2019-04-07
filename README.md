#计算机设计大赛项目作品
SSM+Shiro,基于RESTful风格的校园论坛平台
---
##4月2日
完成Spring,Spring MVC整合,项目开源放在GitHub
##4月3日
Spring MVC在运行时出现
No mapping found for HTTP request with URI [/mypaltform/user] in DispatcherServlet with name 'dispatcher'
暂时认为是配置文件有问题(但是我觉得没问题啊... 感冒了,不想工作... 白天在改吧)
Log4j的配置也有问题,虽然不影响运行.但是日志会爆红,白天处理
##4月7号
感冒终于好差不多了...修复了之前找不到Controller映射的问题,貌似是因为Servlet配置文件中没有使用这个
<mvc:annotation-driven/>标签,导致没有开启注解的问题,晚上集成Shiro和Log4j2日志组件,然后就可以专心写业务逻辑了



