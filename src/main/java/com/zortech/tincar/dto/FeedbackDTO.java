package com.zortech.tincar.dto;

import com.zortech.tincar.model.Feedback;
import com.zortech.tincar.model.enums.FeedbackType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeedbackDTO {

    private Long id;
    private FeedbackType type;
    private Date createdDate;
    private UserDTO user;
    private VehicleDTO vehicle;
    private Long userId;
    private Long vehicleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FeedbackType getType() {
        return type;
    }

    public void setType(FeedbackType type) {
        this.type = type;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public static Feedback from(FeedbackDTO dto) {
        if(dto == null)
            return null;
        Feedback entity = new Feedback();
        entity.setId(dto.getId());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setType(dto.getType());
        entity.setUser(UserDTO.from(dto.getUser()));
        entity.setVehicle(VehicleDTO.from(dto.getVehicle()));
        return entity;
    }

    public static FeedbackDTO from(Feedback entity) {
        if(entity == null)
            return null;
        FeedbackDTO dto = new FeedbackDTO();
        dto.setId(entity.getId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setType(entity.getType());
        dto.setUserId(entity.getUser().getId());
        dto.setVehicleId(entity.getVehicle().getId());
        return dto;
    }

    public static List<Feedback> fromDTOs(List<FeedbackDTO> dtos) {
        if(dtos == null)
            return null;
        List<Feedback> entities = new ArrayList<>();
        for(FeedbackDTO dto: dtos){
            entities.add(FeedbackDTO.from(dto));
        }
        return entities;
    }

    public static List<FeedbackDTO> from(List<Feedback> entities) {
        if(entities == null)
            return null;
        List<FeedbackDTO> dtos = new ArrayList<>();
        for(Feedback entity: entities){
            dtos.add(FeedbackDTO.from(entity));
        }
        return dtos;
    }
}
