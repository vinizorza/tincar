package com.zortech.tincar.service;

import com.zortech.tincar.model.User;
import com.zortech.tincar.model.Vehicle;
import com.zortech.tincar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    public void save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    public Vehicle getById(Long id){
        return vehicleRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        Vehicle vehicle = getById(id);
        if(vehicle != null)
            vehicleRepository.delete(vehicle);
    }

    public List<Vehicle> listCandidatesVehicles(Vehicle filter) {
        String email = userDetailsService.getUsername();
        User user = userService.findUsuarioByEmail(email);
        return vehicleRepository.listVehiclesCandidates(user.getId(), filter.getModel());
    }

    public List<Vehicle> listMyVehicles() {
        String email = userDetailsService.getUsername();
        User user = userService.findUsuarioByEmail(email);
        return vehicleRepository.listVehiclesByUser(user.getId());
    }
}
