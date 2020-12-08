package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
public class MusicAppSongApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicAppSongApplication.class, args);
	}

}
