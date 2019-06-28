package com.lanchuang.publish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.lanchuang")
public class PublishApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublishApplication.class, args);
    }

}
