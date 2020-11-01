package com.aggregator.goodNews.controller;

import com.aggregator.goodNews.dto.LoginForm;
import com.aggregator.goodNews.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.ConcurrentHashMap;

@Controller
public class LoginController {

    private ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>() {{
        put("vasya", new User("vasya", "1234", 18));
        put("katya", new User("katya", "katya", 16));
    }};

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("form", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String loginHandler(Model model, @ModelAttribute LoginForm form) {

        if (!users.containsKey(form.getLogin())) {
            model.addAttribute("error", true);
            model.addAttribute("form", new LoginForm());
            return "login";
        }
        else if (!form.getPassword().equals(users.get(form.getLogin()).getPassword())) {
            model.addAttribute("error", true);
            model.addAttribute("form", new LoginForm());
            return "login";
        }
        model.addAttribute("form", new LoginForm());
        model.addAttribute("user", users.get(form.getLogin()));
        return "redirect:/profile/" + form.getLogin() + "/?password=" + form.getPassword();
    }
}
