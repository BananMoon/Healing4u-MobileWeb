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

    @GetMapping("/home/response")
    public String res() {
        return "index2";
    }

/*
    // List와 ArrayList 차이
    // List : 인터페이스, ArrayList : 클래스
    //  ArrayList 는 동적으로 크기를 변경할 수 있다.
    //  '특정' 위치에 element를 추가, 삭제가 가능하다.
    // Generic 을 사용하지 않고 선언한다면 다양한 타입의 객체를 저장할 수 있다.
    // ListIterator 를 사용해 양방향 순회가 가능하다.
 */
}

