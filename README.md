#计算机设计大赛项目作品
SSM,基于RESTful风格的校园论坛平台
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
##4月9号
放弃Shiro,时间宽裕的时候在研究吧,白天完成用户登录以及注册
##4月10号
打算完成用户模块,但是不会写jsp..白天完成用户模块.更改了一下数据表;
第二次更新:注册模块测试通过,存在用户密码明文保存问题,使用MD5加密;SpringMVC视图跳转也有待研究
##4月15日
用户模块,jsp页面,数据库更新;距离交作品就剩一周了,啊啊啊写不完了.还会有一堆bug 16:03
首页,footer和header,signin和signup前后沟通完毕 17:17
注册功能通过 email属于虚假字段,数据库中并没有该字段 登录功能还有待研究 22:41
注册功能,登录功能,登出功能(即用户模块全部功能)实现测试通过,白天写Topic模块 0:02
##4月16日
用户模块除了用户主页全部通过(用户主页需要完成Topic模块才能补齐)
增加Topic和Reply数据库表,创建新主题页面和后端对接
BUGFIX,Tomcat启动异常抛出java.lang.IllegalStateException,原因是:队友瞎说话
(MyBatis中SQL语句有问题而且user表中没有设计头像字段导致访问Setting时,报了500)
##4月19日
虽然不知道发生了什么 但是本地的数据库没了 妈了个鸡 还以为是业务逻辑出了问题 还好数据库里没有什么信息
抽时间研究一下为什么数据库会消失 晚上写Topic展示部分代码 然后做PPT,写开发文档 15:56
##4月20日
用户个人信息模块基本完成 还有待修补 14:51
User resuser = userService.getUserByName("username");报错500 空指针异常 说明没找到这个用户
先去修电脑 然后晚上修改 15:01
memberInfo块的空指针异常问题通过改变User的获取方法得到解决 但是getUserbyname还是存在空指针的问题 19:17
##4月21号
除去Reply还差帖子展示页面,而且主页新建帖子的时间戳有问题 晚上修复 16:34
##4月23号
当了一天运维人员 买了个阿里云服务器用来部署项目 日期问题还没解决 白天解决
最后一块404和日期问题也在白天解决 看时间情况考虑是否增加回复功能(大概率要增加)
日期问题BUGFIX 创建新主题后页面跳转的问题也修复了 就差进入主题的/t/{id}的URL没有处理 17:13
帖子页面对应的接口写完 晚上完善 打成war包部署到服务器 明天提交项目17:50
帖子页面写完了 似乎未登录状态下访问username的href有BUG 24号之前写完 23:24
项目基本完成 部署测试上线
