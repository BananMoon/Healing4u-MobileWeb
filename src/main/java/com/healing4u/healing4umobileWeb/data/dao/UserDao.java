package com.healing4u.healing4umobileWeb.data.dao;
import com.healing4u.healing4umobileWeb.data.entity.UserEntity;

public interface UserDao {
    UserEntity getUserEntity(long userId);
}
