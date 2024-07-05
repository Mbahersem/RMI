package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.pulsar.annotation.EnablePulsar;

@EnableCassandraRepositories(basePackages = "com.example.demo.repository")
@EnablePulsar
@SpringBootApplication
public class IngestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(IngestionApplication.class, args);
	}

}
