package com.healing4u.healing4umobileWeb;

import com.healing4u.healing4umobileWeb.repository.UserRepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Healing4uMobileWebApplicationTests {

	UserRepositoryTest userRepositoryTest;
	@Test
	void contextLoads() {
		userRepositoryTest.select();
	}

}
