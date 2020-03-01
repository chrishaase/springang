package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {


    @Value("${app.baseUrl}")
    private String baseUrl;

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)

    public String error() {
        System.out.println("baseUrl " + baseUrl);
        return "redirect:"+baseUrl;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
