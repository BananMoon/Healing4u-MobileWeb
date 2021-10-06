package com.healing4u.healing4umobileWeb.repository;

import com.healing4u.healing4umobileWeb.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserRepositoryTest {
    private UserRepository userRepository;

    @Test
    public void select() {
        List<User> result = userRepository.findAll();
        for (User i : result) {
            System.out.println(i.getUser_id());
        }
    }
}

