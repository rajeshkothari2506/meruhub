package com.meru.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MeruEurekaDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeruEurekaDiscoveryServerApplication.class, args);
	}

}
