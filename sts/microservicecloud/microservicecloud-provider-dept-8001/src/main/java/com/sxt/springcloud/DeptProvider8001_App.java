package com.sxt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient    // 将此服务作为Eureka客户端注册进eureka
@EnableDiscoveryClient
public class DeptProvider8001_App {

	public static void main(String[] args) {
		
		SpringApplication.run(DeptProvider8001_App.class, args);

	}

}
