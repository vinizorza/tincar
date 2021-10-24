package com.zortech.tincar.controller;

import com.zortech.tincar.dto.VehicleDTO;
import com.zortech.tincar.model.Vehicle;
import com.zortech.tincar.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public VehicleDTO getVehicle(@PathVariable("id") Long id){
        return VehicleDTO.from(vehicleService.getById(id));
    }

    @RequestMapping(value="/me/vehicles/candidates", method=RequestMethod.GET)
    public List<VehicleDTO> listCandidatesVehicles(VehicleDTO filter){
        Vehicle vehicle = VehicleDTO.from(filter);
        List <Vehicle> vehicles = vehicleService.listCandidatesVehicles(vehicle);
        return VehicleDTO.from(vehicles);
    }

    @RequestMapping(value="/me/vehicles", method=RequestMethod.GET)
    public List<VehicleDTO> listMyVehicles(){
        List <Vehicle> vehicles = vehicleService.listMyVehicles();
        return VehicleDTO.from(vehicles);
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    public void saveVehicle(@RequestBody VehicleDTO vehicle){
        vehicleService.save(VehicleDTO.from(vehicle));
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public void deleteVehicle(@PathVariable("id") Long id){
        vehicleService.delete(id);
    }
    
}