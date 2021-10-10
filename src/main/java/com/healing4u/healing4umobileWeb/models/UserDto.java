package com.healing4u.healing4umobileWeb.models;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    @NotNull
    private long user_id;

    private int now_emotion;

    private int rating;

    private String today;

    @NotNull
    private int ad_id;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .user_id(user_id)
                .now_emotion(now_emotion)
                .rating(rating)
                .today(today)
                .ad_id(ad_id)
                .build();
    }
}
