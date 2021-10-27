package com.healing4u.healing4umobileWeb.domain.users;

import com.healing4u.healing4umobileWeb.domain.advertisement.Advertisement;
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
public class Users {
    @Column(name="urser_id", nullable = false)
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
