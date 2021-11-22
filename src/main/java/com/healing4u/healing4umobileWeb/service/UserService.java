package com.healing4u.healing4umobileWeb.service;

import com.healing4u.healing4umobileWeb.dto.UsersResponseDto;
import com.healing4u.healing4umobileWeb.model.Advertisement;
import com.healing4u.healing4umobileWeb.model.User;
import com.healing4u.healing4umobileWeb.repository.AdvertisementRepository;
import com.healing4u.healing4umobileWeb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdvertisementRepository advertisementRepository;

    // 기분과 사용자 광고 조회
    public Map<String, Integer> findEmotionAndAdId (Long userId) {
        Map<String, Integer> data = new HashMap<String, Integer>();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 아이디가 없습니다."));

//        System.out.println(user.getNowEmotion().getClass());    //class java.lang.Integer
//        System.out.println(user.getAdId().getClass());  // class com.healing4u.healing4umobileWeb.model.Advertisement
        System.out.println(user.getAdId());
//        Integer adId = Integer.parseInt(user.getAdId().toString());
        Integer adId = Integer.valueOf(String.valueOf(user.getAdId()));   // com.healing4u.healing4umobileWeb.model.Advertisement@116da866

        data.put("emotion", user.getNowEmotion());
        data.put("adId", adId);
        // for loop (keySet())
        System.out.println("======해당 사용자의 emotion과 adId 조회======");
        Set<String> keySet = data.keySet();
        for (String key : keySet) {
            System.out.println(key + " : " + data.get(key));
        }
        return data;
    }
    
//    public List<Object[]> countEmotions() {
//        return userRepository.countEmotions();
//    }

//    public UsersResponseDto findById(Long userId) {
//        Users entity = usersRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("해당 아이디가 존재하지 않스비다. id= " +userId));
//
//        return new UsersResponseDto(entity);
//    }
//
    //사용자 id로 표정 가져오기


    //사용자 id의 광고 id를 가져와서 로컬 db에 저장하기
//    public void localSaveAdId(Long userId) {
//    }
}
