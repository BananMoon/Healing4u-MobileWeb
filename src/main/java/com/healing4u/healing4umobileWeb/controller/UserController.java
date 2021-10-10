package com.healing4u.healing4umobileWeb.controller;

//Controller에서 Service를 호출 Mapper 인터페이스를 통해 Mapper.xml에 있는 쿼리를 실행해
//원하는 응답을 조회하도록 하겠습니다.

import com.healing4u.healing4umobileWeb.models.UserDto;
import com.healing4u.healing4umobileWeb.models.UserEntity;
import com.healing4u.healing4umobileWeb.models.UserRepository;
import com.healing4u.healing4umobileWeb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

//    @GetMapping("/home/{userId}")
//    public UserDto getUserEntity(@PathVariable long userId) {
//        // 1. users 테이블 - now_emotion, ad_id
//        //   now_emotion : my weather에 사용
//        //   ad_id : 다른 함수에서 사용 (advertisement 테이블에서 조회 예정)
//
//        //id로 데이터 조회
//        UserEntity user = userRepository.findById(userId).orElseThrow(
//                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );

        // 2. users 테이블 - 금일 모든 users의 now_emotion
        // findALl() -> (updatedAt 기준) 오늘 날짜에 해당하는 now_emotion 갯수 세기
        //     전체 now_emotion : our weather에 사용

        // 3. users 테이블 - 일주일 간 모든 users 테이블의 광고별 ranking값 집계 -> 3위
        //     (updatedAt 기준) 일주일 내에 해당하는 upsers의 ranking 값과 ad_id 집계 (ad-id 별 ranking값 +)
        //      : Ranking 에 사용


//        userRepository.fromJSONtoItems(resultString);


//        return userService.getUserEntity(userId);
//    }



//    @PutMapping("/home/{userId}")
//    public UserDto getUser(@PathVariable long userId) {
//        //컨트롤러 -> 서비스 -> 엔티티
//
//    }


}
