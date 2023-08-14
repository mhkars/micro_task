package com.halit.controller;

import com.halit.exception.VehicleManagerException;
import com.halit.exception.ErrorType;
import com.halit.repository.entity.Vehicle;
import com.halit.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.halit.constansts.ApiUrls.CREATE;
import static com.halit.constansts.ApiUrls.VEHICLE;

@RestController
@RequiredArgsConstructor
@RequestMapping(VEHICLE)
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> createPost(@RequestBody Vehicle vehicle) {
        try {
            vehicleService.create(vehicle);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            throw new VehicleManagerException(ErrorType.VEHICLE_NOT_CREATED);
        }
    }
}
