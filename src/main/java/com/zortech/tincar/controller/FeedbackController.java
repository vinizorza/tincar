package com.zortech.tincar.controller;

import com.zortech.tincar.dto.FeedbackDTO;
import com.zortech.tincar.model.enums.FeedbackType;
import com.zortech.tincar.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(method=RequestMethod.GET)
    public List<FeedbackDTO> listFeedback(@RequestParam Long userId,
                                          @RequestParam String type){
        return FeedbackDTO.from(feedbackService.listByFilter(userId, FeedbackType.from(type)));
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public FeedbackDTO getFeedback(@PathVariable("id") Long id){
        return FeedbackDTO.from(feedbackService.getById(id));
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    public void saveFeedback(@RequestBody FeedbackDTO feedback){
        feedbackService.save(FeedbackDTO.from(feedback));
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public void deleteFeedback(@PathVariable("id") Long id){
        feedbackService.delete(id);
    }
    
}
