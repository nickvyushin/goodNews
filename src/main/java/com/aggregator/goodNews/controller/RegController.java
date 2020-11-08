package com.aggregator.goodNews.controller;

import com.aggregator.goodNews.dto.RegForm;
import com.aggregator.goodNews.model.User;
import com.aggregator.goodNews.model.UserBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegController {

    @GetMapping("/registration")
    public String regPage(Model model, @ModelAttribute RegForm form) {
        model.addAttribute("form", new RegForm());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(Model model, @ModelAttribute RegForm form) {
        var user = new User(form.getFullName(), form.getAge(), form.getLogin(), form.getPassword());
        if (!UserBase.globalBase.add(user)) {
            model.addAttribute("error", true);
            model.addAttribute("form", new RegForm());
            return "registration";
        } else {
            return "redirect:/profile/" + form.getLogin() + "/" + form.getFullName() + "/" + form.getAge() + "/?password=" + form.getPassword();
        }
    }
}
