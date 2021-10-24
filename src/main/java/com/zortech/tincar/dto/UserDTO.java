package com.zortech.tincar.dto;

import com.zortech.tincar.model.User;

import javax.persistence.Column;

public class UserDTO {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static User from(UserDTO dto) {
        User entity = new User();
        entity.setEmail(dto == null ? null : dto.getEmail());
        entity.setId(dto == null ? null : dto.getId());
        entity.setName(dto == null ? null : dto.getName());
        entity.setPhoneNumber(dto == null ? null : dto.getPhoneNumber());
        entity.setPassword(dto == null ? null : dto.getPassword());
        return entity;
    }

    public static UserDTO from (User entity){
        if(entity == null)
            return null;
        UserDTO dto = new UserDTO();
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setId(entity.getId());
        return dto;
    }
}
