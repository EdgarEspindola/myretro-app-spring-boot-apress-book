package com.example.myretro;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyretroApplication {

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(MyretroApplication.class);
		sa.setBannerMode(Banner.Mode.OFF);
		sa.run(args);
	}

}
