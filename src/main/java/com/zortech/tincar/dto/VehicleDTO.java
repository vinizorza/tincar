package com.zortech.tincar.dto;

import com.zortech.tincar.model.Feedback;
import com.zortech.tincar.model.User;
import com.zortech.tincar.model.Vehicle;
import com.zortech.tincar.model.enums.VehicleType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VehicleDTO {

    private Long id;
    private VehicleType type;
    private String brand;
    private String model;
    private Integer modelYear;
    private Integer year;
    private BigDecimal price;
    private String locationPoint;
    private UserDTO user;
    private List<FeedbackDTO> feedbacks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLocationPoint() {
        return locationPoint;
    }

    public void setLocationPoint(String locationPoint) {
        this.locationPoint = locationPoint;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<FeedbackDTO> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackDTO> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public static List<VehicleDTO> from(List<Vehicle> entities){
        List<VehicleDTO> dtos = new ArrayList<>();
        for(Vehicle entity: entities){
            dtos.add(VehicleDTO.from(entity));
        }
        return dtos;
    }

    public static Vehicle from(VehicleDTO dto) {
        if(dto == null)
            return null;

        Vehicle entity = new Vehicle();
        entity.setBrand(dto.getBrand());
        entity.setId(dto.getId());
        entity.setModel(dto.getModel());
        entity.setLocationPoint(dto.getLocationPoint());
        entity.setPrice(dto.getPrice());
        entity.setModelYear(dto.getModelYear());
        entity.setYear(dto.getYear());
        entity.setType(dto.getType());
        entity.setFeedbacks(FeedbackDTO.fromDTOs(dto.getFeedbacks()));
        entity.setUser(UserDTO.from(dto.getUser()));
        return entity;
    }

    public static VehicleDTO from(Vehicle entity) {
        if(entity == null)
            return null;

        VehicleDTO dto = new VehicleDTO();
        dto.setBrand(entity.getBrand());
        dto.setId(entity.getId());
        dto.setModel(entity.getModel());
        dto.setLocationPoint(entity.getLocationPoint());
        dto.setPrice(entity.getPrice());
        dto.setModelYear(entity.getModelYear());
        dto.setYear(entity.getYear());
        dto.setType(entity.getType());
        dto.setFeedbacks(FeedbackDTO.from(entity.getFeedbacks()));
        dto.setUser(UserDTO.from(entity.getUser()));
        return dto;
    }
}
