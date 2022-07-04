package com.summarizer.complaints;

import com.summarizer.complaints.config.StorageProperties;
import com.summarizer.complaints.domain.fileupload.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ComplaintsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ComplaintsApplication.class, args);
	}
}
