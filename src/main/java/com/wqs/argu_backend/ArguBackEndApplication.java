package com.wqs.argu_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //(exclude = MongoAutoConfiguration.class)
public class ArguBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArguBackEndApplication.class, args);
    }

}
