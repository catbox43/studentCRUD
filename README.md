## studentCRUD
* 采用前后端分离的模式，前端使用Sword框架，后端使用SpringBlade。
* 集成Sentinel从流量控制、熔断降级、系统负载等多个维度保护服务的稳定性。
* 注册中心、配置中心选型Nacos，为工程瘦身的同时加强各模块之间的联动。
## 实现的功能
* 添加班级、模糊搜索班级、修改班级信息、批量逻辑删除班级。
* 添加学生，选择班级是动态获取所有班级，并带有模糊搜索班级的功能。
* 修改学生，选择班级同上。
* 模糊搜索学生。
* 批量逻辑删除学生。
## 工程结构
```
studentCRUD
├── doc -- 其他文件
├    ├── Sql -- 数据库表结构和数据
├    └── Student -- 前端页面
├── scrud-common -- 常用工具封装包
├── scrud-gateway -- Spring Cloud 网关
├── scrud-service -- 业务模块
├    ├── scrud-grader -- 班级模块 
├    └── scrud-student -- 学生模块 
├── scrud-service-api -- 业务模块api封装
├    ├── scrud-grader-api -- 班级api 
└──  └── scrud-student-api -- 学生api 
```