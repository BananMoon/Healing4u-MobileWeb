package com.healing4u.healing4umobileWeb.data.repository;
import com.healing4u.healing4umobileWeb.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //24시간 목록 조회 메서드

    //1주일 목록 조회 메서드

}