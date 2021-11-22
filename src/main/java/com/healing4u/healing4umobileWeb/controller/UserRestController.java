package com.healing4u.healing4umobileWeb.controller;


import com.healing4u.healing4umobileWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("/setId/{userId}")
    public Map<String, Integer> home(@PathVariable  Long userId) {
        System.out.println("controller에서 : "+ userId);
        // userId로 기분 & 광고 조회.
        Map<String, Integer> emotionAndAdId = userService.findEmotionAndAdId(userId);
        // 광고를 로컬 db에 저장.
        return emotionAndAdId;
    }
}
