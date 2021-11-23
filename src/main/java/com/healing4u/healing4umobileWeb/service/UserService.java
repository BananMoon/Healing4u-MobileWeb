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
    public HashMap<String, Integer> findEmotionAndAdId (Long userId) {
        HashMap<String, Integer> emotionAndAdId = new HashMap<String, Integer>();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 아이디가 없습니다."));

//        System.out.println(user.getNowEmotion().getClass());    //class java.lang.Integer
//        System.out.println(user.getAdId().getClass());  // class com.healing4u.healing4umobileWeb.model.Advertisement
        System.out.println(user.getAdId());
//        Integer adId = Integer.parseInt(user.getAdId().toString());
        Integer adId = Integer.valueOf(String.valueOf(user.getAdId()));   // com.healing4u.healing4umobileWeb.model.Advertisement@116da866

        emotionAndAdId.put("nowEmotion", user.getNowEmotion());
        emotionAndAdId.put("adId", adId);
        // for loop (keySet())
        System.out.println("======해당 사용자의 emotion과 adId 조회======");
        Set<String> keySet = emotionAndAdId.keySet();
        for (String key : keySet) {
            System.out.println(key + " : " + emotionAndAdId.get(key));
        }
        return emotionAndAdId;
    }

//    public List<Object[]> findEmotionCount() {
    public  HashMap<String,Integer> findEmotionCount() {

        List<Object[]> emotionQuery= userRepository.countEmotions();
        HashMap<String,Integer> emotionMap = new HashMap<String, Integer>();

        // Object[] 이므로 형변환 해줘야한다.
        for (Object[] o : emotionQuery) {
            String emotion = String.valueOf( o[0]);
            int count = Integer.parseInt(o[1].toString());
            emotionMap.put(emotion, count);
        }
        System.out.println(emotionMap.entrySet());
        return emotionMap;
    }

//    public void localSaveAdId(Long userId) {
//    }
}
