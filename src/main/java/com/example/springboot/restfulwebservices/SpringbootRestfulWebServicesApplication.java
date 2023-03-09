package com.example.springboot.restfulwebservices;

import com.example.springboot.restfulwebservices.service.IMPl.ServiceConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Import(ServiceConfig.class)
@SpringBootApplication
public class SpringbootRestfulWebServicesApplication {

	@Bean // This is a bean tha
	// t will be used by Spring to inject the ModelMapper object into our controller.
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {


		SpringApplication.run(SpringbootRestfulWebServicesApplication.class, args);

	}

}
