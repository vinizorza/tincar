package com.zortech.tincar.service;

import com.zortech.tincar.model.Feedback;
import com.zortech.tincar.model.User;
import com.zortech.tincar.model.Vehicle;
import com.zortech.tincar.model.enums.FeedbackType;
import com.zortech.tincar.repository.FeedbackRepository;
import com.zortech.tincar.repository.UserRepository;
import com.zortech.tincar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    public void save(Feedback feedback){
        feedback.setCreatedDate(new Date());
        //Vehicle vehicle = vehicleRepository.getById(feedback.getVehicle().getId());
        //User user = userRepository.getById(feedback.getUser().getId());

        feedbackRepository.save(feedback);
    }

    public List<Feedback> listByFilter(Long userId, FeedbackType type){
        return feedbackRepository.listByFilter(userId, type);
    }

    public Feedback getById(Long id){
        return feedbackRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        Feedback feedback = getById(id);
        if(feedback != null)
            feedbackRepository.delete(feedback);
    }

}
