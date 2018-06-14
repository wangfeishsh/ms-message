package com.ypp.msmessage;

import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsMessageApplication  extends SpringBootServletInitializer {

	@Bean
	public OkHttpClient client(){
		//this.connectTimeout = 10000;
		//this.readTimeout = 10000;
		//this.writeTimeout = 10000;
		return new OkHttpClient();
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(MsMessageApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MsMessageApplication.class, args);
	}
}
