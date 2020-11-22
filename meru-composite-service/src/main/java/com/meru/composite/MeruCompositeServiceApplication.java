package com.meru.composite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.meru.composite")
public class MeruCompositeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeruCompositeServiceApplication.class, args);
	}

}
