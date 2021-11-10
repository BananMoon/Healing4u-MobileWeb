package com.healing4u.healing4umobileWeb.service;

import com.healing4u.healing4umobileWeb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Object> countEmotions() {
        return userRepository.countEmotions();
    }
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
