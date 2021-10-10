package com.healing4u.healing4umobileWeb.models;
import com.healing4u.healing4umobileWeb.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //24시간 목록 조회 메서드

    //1주일 목록 조회 메서드

    public List<UserDto> fromJSONtoItems(String result);
}