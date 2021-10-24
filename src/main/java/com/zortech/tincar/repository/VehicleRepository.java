package com.zortech.tincar.repository;

import com.zortech.tincar.model.Feedback;
import com.zortech.tincar.model.Vehicle;
import com.zortech.tincar.model.enums.FeedbackType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query(value = "SELECT v FROM Vehicle v " +
            " WHERE v.user.id <> :userId " +
            " AND v.id not in (SELECT f.vehicle.id FROM Feedback f WHERE f.user.id = :userId) " +
            " AND v.model = :model")
    List<Vehicle> listVehiclesCandidates(
            @Param("userId") Long userId,
            @Param("model") String model
    );

    @Query(value = "SELECT v FROM Vehicle v " +
            " WHERE v.user.id = :id ")
    List<Vehicle> listVehiclesByUser(@Param("id") Long id);
}
