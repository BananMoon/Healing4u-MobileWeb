package com.healing4u.healing4umobileWeb.service;

import com.healing4u.healing4umobileWeb.data.dto.UserDto;
import com.healing4u.healing4umobileWeb.data.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.healing4u.healing4umobileWeb.data.handler.UserDataHandler;

//클라이언트에서 컨트롤러, 컨트롤러에서 서비스, 각 계층간 이동은 Dto
//서비스에서 DAO, DAO에서 데이터베이스로의 계층 간 이동은 Entity로 !
// Dto -> Entity 변환은 컨트롤러에서 하고, 비즈니스로직을 돌리는 것이 이론적으로 있지만,
// 팀마다, 아예 Dto로만 하는 곳도 있음.

@Service
public class UserServiceImpl implements UserService{

    UserDataHandler userDataHandler;

    @Autowired
    public UserServiceImpl(UserDataHandler userDataHandler) {
        this.userDataHandler = userDataHandler;
    }

    @Override
    public UserDto getUserEntity(long userId) {
        UserEntity user = userDataHandler.getUserEntity(userId);

        UserDto userDto = new UserDto(user.getUser_id(), user.getNow_emotion(), user.getRating(),
                user.getToday(), user.getAd_id());

        return userDto;
    }

//    private final UserRepository userRepository;
//
//    public List<User> findUsers() {
//        return userRepository.findAll();
//    }
//    public User getUser (int user_id) {
//        return userMapper.getUser(user_id);
//    }
}
