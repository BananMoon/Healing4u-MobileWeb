package com.healing4u.healing4umobileWeb.service;

import com.healing4u.healing4umobileWeb.models.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//클라이언트에서 컨트롤러, 컨트롤러에서 서비스, 각 계층간 이동은 Dto
//서비스에서 DAO, DAO에서 데이터베이스로의 계층 간 이동은 Entity로 !
// Dto -> Entity 변환은 컨트롤러에서 하고, 비즈니스로직을 돌리는 것이 이론적으로 있지만,
// 팀마다, 아예 Dto로만 하는 곳도 있음.

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    public void updateUser(long userId) {

    }

}
