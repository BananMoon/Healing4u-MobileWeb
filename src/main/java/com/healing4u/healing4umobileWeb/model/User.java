package com.healing4u.healing4umobileWeb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    private int now_emotion;

    private int rating;

    private String today;

    @Column(nullable = false)
    private int ad_id;

//    @Column(nullable = false)
//    private LocalDateTime createdAt;

}