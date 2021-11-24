package com.healing4u.healing4umobileWeb.controller;


import com.healing4u.healing4umobileWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class UserRestController {
    @Autowired
    private UserService userService;

    /*
    @GetMapping("/home/{userId}")
    public String home(@PathVariable  Long userId, Model model) {
        System.out.println("controller에서 : "+ userId);
        HashMap<String, Integer> allData;

         // ========== 1. userId로 기분 & 광고 조회 -> allData에 추가
        allData = userService.findEmotionAndAdId(userId);   // {nowEmotion: 11, adId: 16}

        // ===========  2. 사용자의 emotion 합계 조회
        HashMap<String,Integer> emotionMap = userService.findEmotionCount();    // {0: 15, 1: 19, 2: 4}
//        HashMap<String,Integer> emotionMap = new HashMap<String, Integer>();

        // ===========  3. 데이터 합치기
        for (String key : emotionMap.keySet()) {
            Integer value = emotionMap.get(key);
            allData.put("emotion"+ key, emotionMap.get(key));   // {nowEmotion: 11, adId: 16, emotion0 : 15, emotion1: 19, emotion2 : 4}
        }
        System.out.println(allData.entrySet()); // [nowEmotion=1, adId=19, emotion2=232, emotion1=21, emotion0=11]

        // scripts.js에 응답함...
        // userId, emotion

        // =========== 4. localDB에 사용자 id와 광고 id 적어주기 -> 브라우저에 전달하면 브라우저에서 처리
        model.addAttribute("data", allData);    // data로 index.mustache에 전달한다. (뷰 템플릿에 데이터 넘기기)
        return "index2";
//        return allData;
    }*/


    @GetMapping("/home/{userId}")
    public String home(@PathVariable  Long userId, Model model) {

        /* localDB에 사용자 id와 광고 id 적어주기 -> 브라우저에 전달하면 브라우저에서 처리 */
        model.addAttribute("data", userService.findUserData(userId));
        return "index2";

    }
    /* adId를 로컬db에 저장 -> 브라우저에서 처리*/

}
