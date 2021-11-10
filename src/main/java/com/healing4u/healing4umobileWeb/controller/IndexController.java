package com.healing4u.healing4umobileWeb.controller;

import com.healing4u.healing4umobileWeb.model.Advertisement;
import com.healing4u.healing4umobileWeb.model.User;
import com.healing4u.healing4umobileWeb.repository.UserRepository;
import com.healing4u.healing4umobileWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class IndexController {
    UserRepository userRepository;

    @Autowired
    private UserService userService;
// qrcode로부터 요청되는 api -> 페이지가 로드되면서 "/home/user/{userId}" 다시 ajax로 호출?
//    @GetMapping("/")
//    public String index(@PathVariable Long userId) {
//        userId로 정보 찾은 후 함께 뿌려줘야함..
//        return "index";
//    }

    @GetMapping("/emotion")
    public List<Object> list() {
//        List<Object> li =
//        System.out.println(li.get(0));
//        System.out.println((String)li.get(1));
//        System.out.println(li.get(2).toString());
        List<Object> al= userService.countEmotions();
        // 어떻게 값을 나타내지?
//        for (Object objArr : al) {
//            System.out.println(objArr);
//        }
//        System.out.println(Arrays.deepToString(al));

        System.out.println(al); // [[Ljava.lang.Object;@672dfc21, [Ljava.lang.Object;@29da6254, [Ljava.lang.Object;@46543ce1]
//        return userService.countEmotions();
        return al;
    }

    // http://localhost:2004/home/user/11
    @GetMapping("/home/user/{userId}")
    public User getUsers(@PathVariable Long userId) {
        // =========== userId의 해당하는 광고id를 가져와서 로컬db에 저장
        User user =  userRepository.findById(userId).orElseThrow(() -> {
            return new NullPointerException("해당 사용자는 없습니다. id : "+ userId);
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
