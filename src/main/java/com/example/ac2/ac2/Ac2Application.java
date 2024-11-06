package com.example.ac2.ac2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@EntityScan(basePackages = "entity")
public class Ac2Application {

    public static void main(String[] args) {
        SpringApplication.run(Ac2Application.class, args);
    }

    @RequestMapping ("/")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

}
