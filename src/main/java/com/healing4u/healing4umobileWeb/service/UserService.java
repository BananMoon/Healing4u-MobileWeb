package com.healing4u.healing4umobileWeb.service;

import com.healing4u.healing4umobileWeb.data.dto.UserDto;

public interface UserService {
    // 클래스에서 구현하게 되면, DBMS를 바꿀 때, 인터페이스를 이용하는게 의존성이 적을 수 있음

    UserDto getUserEntity(long user_id);

}
