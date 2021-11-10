package com.healing4u.healing4umobileWeb.test;

import com.healing4u.healing4umobileWeb.model.Advertisement;
import com.healing4u.healing4umobileWeb.model.User;
import com.healing4u.healing4umobileWeb.repository.AdvertisementRepository;
import com.healing4u.healing4umobileWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DummyTest {
    @Autowired      // DI(의존성 주입 : )
    private UserRepository userRepository;

    @Autowired
    private AdvertisementRepository adRepository;

    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user/{userId}")
    public User detail(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            return new IllegalArgumentException("해당 아이디는 존재하지 않습니다. id : " + userId);
        });
    }

    //해당 id가 제공받은 전체 광고 id 찾기
//    @GetMapping("/ad/{userId}")
//    public List<Advertisement> findAdId(@PathVariable Long userId) {
//        // 해당 userId의 전체 광고id 받기.
//    }
}
