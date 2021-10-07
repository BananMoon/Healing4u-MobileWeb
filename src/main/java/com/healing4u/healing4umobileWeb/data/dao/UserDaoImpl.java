package com.healing4u.healing4umobileWeb.data.dao;
import com.healing4u.healing4umobileWeb.data.entity.UserEntity;
import com.healing4u.healing4umobileWeb.data.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {
    UserRepository userRepository;

    //의존성 주입
    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getUserEntity(long userId) {
        UserEntity user = userRepository.getById(userId);
        return user;
    }
}
