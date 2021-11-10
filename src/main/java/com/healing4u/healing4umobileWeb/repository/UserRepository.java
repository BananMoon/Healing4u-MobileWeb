package com.healing4u.healing4umobileWeb.repository;

import com.healing4u.healing4umobileWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

// DAO (Database Access Object)
// 자동으로 bean 등록이 된다. @Repository 생략 가능.
//Database와 같이 저장소에 접근하는 영역
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT " +
            "u.nowEmotion, count(u) " +
            "FROM User u " +
            "GROUP BY u.nowEmotion"
    )
    List<Object> countEmotions();
}
