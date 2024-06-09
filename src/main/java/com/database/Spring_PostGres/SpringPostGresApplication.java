package com.database.Spring_PostGres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringPostGresApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPostGresApplication.class, args);
	}

}
