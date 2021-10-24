package com.zortech.tincar.service;

import com.zortech.tincar.model.User;
import com.zortech.tincar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(User user){
        if(userRepository.findByEmail(user.getEmail()) != null)
            return;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User findUsuarioByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
