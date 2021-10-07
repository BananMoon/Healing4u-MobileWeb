package com.healing4u.healing4umobileWeb.data.handler;

import com.healing4u.healing4umobileWeb.data.dao.UserDao;
import com.healing4u.healing4umobileWeb.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDataHandlerImpl implements UserDataHandler{
    UserDao userDao;

    @Autowired
    public UserDataHandlerImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserEntity getUserEntity(long userId) {
        return userDao.getUserEntity(userId);
    }
}


