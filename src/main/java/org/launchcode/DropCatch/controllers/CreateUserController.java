package org.launchcode.DropCatch.controllers;

import org.launchcode.DropCatch.models.User;
import org.launchcode.DropCatch.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



@Controller
@RequestMapping("user")
public class CreateUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("add")
    public String createUser(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(Model model,
                                         @RequestParam String verifyPassword,
                                         @ModelAttribute @Valid User user,
                                         Errors errors ) {

        if (errors.hasErrors()) {
            return "user/add";
        } else if (!verifyPassword.equals(user.getUserPassword())) {
            model.addAttribute("errors", "Passwords must match!!");
            return "user/add";
        } else {
            userRepository.save(user);
            return "user/user-home";
        }

    }}

