package com.schedulely.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;


@SpringBootApplication
@Controller
public class SchedulelyApp {

    public static void main(String[] args) {
        SpringApplication.run(SchedulelyApp.class, args);
    }

}
