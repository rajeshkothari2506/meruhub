package com.meru.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MeruConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeruConfigServerApplication.class, args);
	}

}
