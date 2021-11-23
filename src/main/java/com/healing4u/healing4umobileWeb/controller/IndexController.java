package com.healing4u.healing4umobileWeb.controller;

import com.healing4u.healing4umobileWeb.model.Advertisement;
import com.healing4u.healing4umobileWeb.model.User;
import com.healing4u.healing4umobileWeb.repository.UserRepository;
import com.healing4u.healing4umobileWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@Controller
public class IndexController {
    UserRepository userRepository;

    @Autowired
    private UserService userService;
// qrcode로부터 요청되는 api -> 페이지가 로드되면서 "/home/user/{userId}" 다시 ajax로 호출?
    @GetMapping("/")
    public String modal() {
        //userId로 정보 찾은 후 함께 뿌려줘야함..
        return "modal";
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }
/*
    // List와 ArrayList 차이
    // List : 인터페이스, ArrayList : 클래스
    //  ArrayList 는 동적으로 크기를 변경할 수 있다.
    //  '특정' 위치에 element를 추가, 삭제가 가능하다.
    // Generic 을 사용하지 않고 선언한다면 다양한 타입의 객체를 저장할 수 있다.
    // ListIterator 를 사용해 양방향 순회가 가능하다.
    @GetMapping("/emotion")
    public HashMap<String,Integer> list() {

        List<Object[]> emotionQuery= userService.findEmotionCount();
        HashMap<String,Integer> emotionMap = new HashMap<String, Integer>();

        // Object[] 이므로 형변환 해줘야한다.
        for (Object[] o : emotionQuery) {
            String emotion = String.valueOf( o[0]);
            int count = Integer.parseInt(o[1].toString());
            emotionMap.put(emotion, count);
        }
        System.out.println(emotionMap.entrySet());

        return emotionMap;
    } */

    // http://localhost:2004/home/user/11
    @GetMapping("/home/user/:userId")
    public User getUsers(@PathVariable Long userId) {
        // =========== userId의 해당하는 광고id를 가져와서 로컬db에 저장
        User user = userRepository.findById(userId).orElseThrow(() -> {
            return new NullPointerException("해당 사용자는 없습니다. id : " + userId);
        });
        Advertisement adId = user.getAdId();
        // 로컬 db에 저장 실행 -> 프론트에서 해야되는 거면, 그냥 user를 리턴하면 될듯함.

        // =========== userId의 now_emotion을 리턴 -> 프론트에서 해야되는 거면, 그냥 user를 리턴하면 될듯함.
        int emotion = user.getNowEmotion();

        // users테이블의 now_emotion (0,1,2)의 count 조회
//        List<Object[]> result = userRepository.findEmotionCount();
//        Map<String, Integer> map = null;
//        if(result != null && !result.isEmpty()){
//            map = new HashMap<String, Integer>();
//            for (Object[] object : result) {
//                map.put(((Long)object[0]),object[1]);
//            }
//        }
        return user;
    }
}

