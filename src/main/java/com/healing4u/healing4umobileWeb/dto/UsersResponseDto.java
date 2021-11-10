package com.healing4u.healing4umobileWeb.dto;

import com.healing4u.healing4umobileWeb.model.Advertisement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UsersResponseDto {
    private Long userId;
    private Integer nowEmotion;
    private Integer rating;
    private Advertisement adId;

}
