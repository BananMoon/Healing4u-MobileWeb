package com.healing4u.healing4umobileWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

//    @PutMapping("/home/{userId}")
//    public void getUsers(@PathVariable Long userId) {
//      userService.updateUser(userId,user
//    };

}
