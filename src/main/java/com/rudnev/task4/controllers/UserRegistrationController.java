package com.rudnev.task4.controllers;

import com.rudnev.task4.model.rapport.UserRequest;
import com.rudnev.task4.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class UserRegistrationController {

    private UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRequest userRegistrationDto() {
        return new UserRequest();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration_view";
    }

    @PostMapping
    @Transactional
    public String registerUserAccount(@ModelAttribute("user") UserRequest userRequest) {
        if (userService.isUserExists(userRequest)) {
            return "redirect:/registration?error";
        }
        userService.save(userRequest);
        return "redirect:/registration?success";
    }

}
