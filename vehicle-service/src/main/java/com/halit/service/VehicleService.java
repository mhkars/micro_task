package com.halit.service;

import com.halit.repository.IVehicleRepository;
import com.halit.repository.entity.Vehicle;
import com.halit.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VehicleService extends ServiceManager<Vehicle,Long> {
    private final IVehicleRepository vehicleRepository;

    public VehicleService (IVehicleRepository vehicleRepository){
        super(vehicleRepository);
        this.vehicleRepository = vehicleRepository;
    }
    @Transactional
    public void create(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}
