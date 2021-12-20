package com.example.testmongodbtemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class TestMongoDBtemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMongoDBtemplateApplication.class, args);
    }

}
