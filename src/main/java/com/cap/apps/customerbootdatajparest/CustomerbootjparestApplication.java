package com.cap.apps.customerbootdatajparest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class CustomerbootjparestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerbootjparestApplication.class, args);
	}

}
