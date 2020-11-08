package com.aggregator.goodNews.controller;

import com.aggregator.goodNews.dto.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    @GetMapping("/profile/{login}/{fullName}/{age}")
    public String profile(Model model, @PathVariable("login")String login, @RequestParam("password")String password, @PathVariable("fullName")String fullName, @PathVariable("age")Integer age) {
        model.addAttribute("request", new LoginForm(login, password));
        return "profile";
    }

}
