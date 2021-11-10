package com.healing4u.healing4umobileWeb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="users")
@Getter
@Entity
public class User {
    @Column(name="user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;

    @Column(name="now_emotion")
    private Integer nowEmotion;

    private Integer rating;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name="ad_id")
    private Advertisement adId;
}
