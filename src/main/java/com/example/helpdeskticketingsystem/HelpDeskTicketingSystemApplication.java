package com.example.helpdeskticketingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HelpDeskTicketingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelpDeskTicketingSystemApplication.class, args);
    }

}
