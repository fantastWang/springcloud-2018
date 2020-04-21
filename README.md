###工程搭建记录，方便回溯记忆
1. 创建父工程microservicecloud，该工程只定义项目架构，即项目依赖所需的jar包
2. 子模块microservicecloud-api，该工程为公共部分，比如实体类，工具等，其他子模块可以依赖它进行开发
   > 这个模块中目前只定义了实体类，用于其他工程方便调用
3. 子模块microservicecloud-provider-dept-8001，该工程为部门微服务生产者8001，对外提供服务
   > 因为是生产者，需要对外提供服务，那么就需要连接数据库进行操作，所以需要存在yml配置文件，定义了服务的基本信息
   和配置及初始化SQL脚本。编写Dao及xml访问数据库

**主启动类的位置要位于最外层，因为springboot启动时，会根据主启动类的位置往里扫描类。不放在最外层，则某些类无法被扫描到
或者 添加@ComponentScan(basePackages ={ "com.it.wcj"})注解，就不能使用原生的@SpringBootApplication,因为包含了@ComponentScan**
