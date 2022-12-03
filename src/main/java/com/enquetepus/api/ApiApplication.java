package com.enquetepus.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication

public class ApiApplication {
//	@Resource
//	FilesStorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		storageService.init();
//
//	}
}
