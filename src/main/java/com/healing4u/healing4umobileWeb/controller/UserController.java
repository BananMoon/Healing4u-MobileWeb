package com.healing4u.healing4umobileWeb.controller;

//Controller에서 Service를 호출 Mapper 인터페이스를 통해 Mapper.xml에 있는 쿼리를 실행해
//원하는 응답을 조회하도록 하겠습니다.

import com.healing4u.healing4umobileWeb.data.dto.UserDto;
import com.healing4u.healing4umobileWeb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/home/{userId}")
    public UserDto getUserEntity(@PathVariable long user_id) {
        return userService.getUserEntity(user_id);
    }
//    }
}
