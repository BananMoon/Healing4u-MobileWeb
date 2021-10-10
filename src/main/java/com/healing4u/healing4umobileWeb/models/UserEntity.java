package com.healing4u.healing4umobileWeb.models;

import com.healing4u.healing4umobileWeb.models.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity { //테이블과 직접적으로 매핑되는 클래스

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    private int now_emotion;

    private int rating;

    private String today;

//    @ManyToOne(fetch = FetchType.LAZY)  //LAZY를 사용하려면, 이걸 사용하는 구간에 Transactional을 붙여줘야 한다.
    @Column(nullable = false)
    private int ad_id;
//    @Column(nullable = false)
//    private LocalDate createdAt;

}

