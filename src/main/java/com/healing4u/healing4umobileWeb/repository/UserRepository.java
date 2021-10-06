package com.healing4u.healing4umobileWeb.repository;
import com.healing4u.healing4umobileWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //24시간 목록 조회 메서드

    //1주일 목록 조회 메서드

}