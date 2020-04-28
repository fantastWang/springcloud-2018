**工程搭建记录，方便回溯记忆**
1. 创建父工程microservicecloud，该工程只定义项目架构，即项目依赖所需的jar包
2. 子模块microservicecloud-api，该工程为**公共部分**，比如实体类，工具等，其他子模块可以依赖它进行开发
   > 这个模块中目前只定义了实体类，用于其他工程方便调用
3. 子模块microservicecloud-provider-dept-8001，该工程为**部门微服务生产者8001**，对外提供服务，后面改成了注册进Eureka的一个实例
  > 因为是生产者，需要对外提供服务，那么就需要连接数据库进行操作，所以需要存在yml配置文件，定义了服务的基本信息
   和配置及初始化SQL脚本。编写Dao及xml访问数据库
4. 子模块microservicecloud-consumer-dept-80，该工程为**部门微服务消费者80**，使用RestTemplate进行访问数据

**遇到的问题，避免下次入坑**
1. 主启动类的位置要位于最外层，因为springboot启动时，会根据主启动类的位置往里扫描类。不放在最外层，则某些类无法被扫描到
或者 添加@ComponentScan(basePackages ={ "com.it.wcj"})注解，就不能使用原生的@SpringBootApplication,因为包含了@ComponentScan
2. 当从GitHub上拉取代码到IDEA时，可能在Maven界面只有一个父工程模块，没有子工程模块，这时候需要找到对应的子工程模块的pom文件，发现
它们都变成了普通的xml文件，需要右键手动"add as maven project"。如果运行主启动类报"找不到主类"，需要File->Project Structure->Modules,
删除右侧的文件即可
3. 因为最开始的时候，是在父工程pom文件中使用dependencies定义了mybatis的相关依赖，导致所有的子模块默认继承了父工程的所有jar包，而当子模块yml文件没有配置数据源时，就会抛出"Cannot determine embedded database driver class for database type NONE"异常，解决方法是在需要的子模块单独定义，或者使用dependencyManagement标签
4. 修改与SpringCloud相对应的SpringBoot的版本，减少因版本不一致出现的各种问题