package com.zortech.tincar.service;

import com.zortech.tincar.TincarApplication;
import com.zortech.tincar.model.User;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TincarApplication.class)
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void get_user_by_id_success() {

        //given
        Long userId = 9L;

        //when
        User user = userService.getById(userId);

        //then
        assertEquals("vinizorza4@hotmail.com", user.getEmail());

    }
}