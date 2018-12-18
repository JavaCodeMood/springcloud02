在微服务架构中，业务都会被拆分成一个独立的服务，服务与服务的通讯是基于http restful的。    
Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign。     
本实例基于ribbon+rest实现；      

ribbon是一个负载均衡客户端，可以很好的控制http和tcp的一些行为。Feign默认集成了ribbon。   

@EnableEurekaServer   //启动一个服务注册中心     
@EnableDiscoveryClient  //向服务中心注册     
@LoadBalanced //表明开启负载均衡的功能     

流程：   
(1) 一个服务注册中心，eureka-server,端口为8081   
(2) eureka-client工程跑了两个实例，端口分别为8082,8083，分别向服务注册中心注册    
(3) sercvice-ribbon端口为8084,向服务注册中心注册    
(4) 当sercvice-ribbon通过restTemplate调用eureka-client的index接口时，
因为用ribbon进行了负载均衡，会轮流的调用eureka-client：8082和8083 两个端口的index接口；    

参考地址：https://blog.csdn.net/forezp/article/details/81040946

