package com.zortech.tincar.repository;

import com.zortech.tincar.model.Feedback;
import com.zortech.tincar.model.User;
import com.zortech.tincar.model.enums.FeedbackType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u " +
            " WHERE u.email = ?1 ")
    User findByEmail(String email);

}
