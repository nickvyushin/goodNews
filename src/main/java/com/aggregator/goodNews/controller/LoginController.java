package com.aggregator.goodNews.controller;

import com.aggregator.goodNews.dto.LoginForm;
import com.aggregator.goodNews.model.UserBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("form", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String loginHandler(Model model, @ModelAttribute LoginForm form) {


        if (!UserBase.globalBase.check(form.getLogin(), form.getPassword())) {
            model.addAttribute("error", true);
            model.addAttribute("form", new LoginForm());
            return "login";
        }

        return "redirect:/profile/" + form.getLogin() + "/" + UserBase.globalBase.findNameByLogin(form.getLogin()) + "/" + UserBase.globalBase.findAgeByLogin(form.getLogin()) + "/?password=" + form.getPassword();
    }
}
