package com.aggregator.goodNews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegController {

    @GetMapping("/registration")
    public String loginPage() {
        return "registration";
    }
}
