package com.zortech.tincar.repository;

import com.zortech.tincar.model.Feedback;
import com.zortech.tincar.model.enums.FeedbackType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query(value = "SELECT f FROM Feedback f " +
            " WHERE f.user.id = ?1 " +
            " AND f.type = ?2 " +
            " ORDER BY f.createdDate DESC")
    List<Feedback> listByFilter(Long userId, FeedbackType type);

}
