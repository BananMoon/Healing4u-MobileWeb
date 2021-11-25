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
    public HashMap<String, String> findEmotionAndAdId (Long userId) {
        HashMap<String, String> emotionAndAdId = new HashMap<String, String>();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 아이디가 없습니다."));

//        System.out.println(user.getNowEmotion().getClass());    //class java.lang.Integer
//        System.out.println(user.getAdId().getClass());  // class com.healing4u.healing4umobileWeb.model.Advertisement
        System.out.println(user.getAdId());
//        Integer adId = Integer.parseInt(user.getAdId().toString());
        String adId = String.valueOf(user.getAdId());   // com.healing4u.healing4umobileWeb.model.Advertisement@116da866
        String nowEmotion = String.valueOf(user.getNowEmotion());
        if (nowEmotion.equalsIgnoreCase("0")) nowEmotion = "맑음";
        else if (nowEmotion.equalsIgnoreCase("1")) nowEmotion = "흐림";
        else if (nowEmotion.equalsIgnoreCase("2")) nowEmotion = "비";

        emotionAndAdId.put("nowEmotion", nowEmotion);
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
    public  HashMap<String,String> findEmotionCount() {

        List<Object[]> emotionQuery= userRepository.countEmotions();
        HashMap<String,String> emotionMap = new HashMap<String, String>();

        // Object[] 이므로 형변환 해줘야한다.
        for (Object[] o : emotionQuery) {
            String emotion = String.valueOf( o[0]);
            String count = String.valueOf(o[1]);
            emotionMap.put(emotion, count);
        }
        System.out.println(emotionMap.entrySet());
        System.out.println("emotion0의 카운트 : "+ emotionMap.get("0"));
        return emotionMap;
    }

    public HashMap<String, String> findUserData(Long userId) {
        System.out.println("userService에서 : "+ userId);
        HashMap<String, String> allData;

        /*  1. userId로 기분 & 광고 조회 -> allData에 추가  */
        allData = findEmotionAndAdId(userId);
//        여기부터 수정 ㄱㄱ!!!!!!

        /*  2. 사용자의 emotion 합계 조회 -> allData에 추가  */
        List<Object[]> emotionQuery= userRepository.countEmotions();
        HashMap<String,String> emotionMap = findEmotionCount();    // {0: 15, 1: 19, 2: 4}
        for (String key : emotionMap.keySet()) {
            String value = emotionMap.get(key);
            allData.put("emotion"+ key, emotionMap.get(key));   // {nowEmotion: 11, adId: 16, emotion0 : 15, emotion1: 19, emotion2 : 4}
        }
        System.out.println(allData.entrySet()); // [nowEmotion="흐림", adId=19, emotion2=232, emotion1=21, emotion0=11]

        /*  3. users 테이블에서 adId 별 가장 높은 rating의 합계 : sum(rating) groupby adId desc (내림차순)  + 된다면 하루 치(24시간) 만  -> allData에 추가 */

        /*  4. adId로 advertisements에서 serviceName, address, phone, detailLong, kakaomapUrl 등을 가져와서 데이터 합치기.   -> allData에 추가 */
        Long adIdValue = Long.valueOf(allData.get("adId"));
        Advertisement adQuery = advertisementRepository.findById(adIdValue)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 광고 아이디가 존재하지 않습니다."));
        allData.put("adAddress", adQuery.getAddress());
        allData.put("adServiceName", adQuery.getServiceName());
        allData.put("adTel", adQuery.getTel());
        allData.put("adKakaoMapUrl", adQuery.getKakaoMapUrl());
        allData.put("adDetailLong", adQuery.getDetailLong());

        return allData;
    }
//    public void localSaveAdId(Long userId) {
//    }
}
