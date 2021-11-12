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
    // select를 통해 여러개의 값을 받는다면 List<Object[]> 타입으로 받은 뒤 형변환해서 사용
    @Query("SELECT " +
            "u.nowEmotion, count(u) " +
            "FROM User u " +
            "GROUP BY u.nowEmotion"
    )
    List<Object[]> countEmotions();

}
