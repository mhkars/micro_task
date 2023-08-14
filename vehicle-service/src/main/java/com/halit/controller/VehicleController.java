package com.halit.controller;

import com.halit.exception.VehicleManagerException;
import com.halit.exception.ErrorType;
import com.halit.repository.entity.Vehicle;
import com.halit.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.halit.constansts.ApiUrls.*;

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
    @GetMapping(GETALLLIST)

    public ResponseEntity<List<Vehicle>> findAllList() {

        return ResponseEntity.ok(vehicleService.findAll());
    }
    @GetMapping(GETALLGROUP)

    public ResponseEntity<List<Vehicle>> findAllGroup() {

        return ResponseEntity.ok(vehicleService.findAll());
    }
    @PutMapping(UPDATE)
    public ResponseEntity<Boolean> updateProfile(@RequestBody @Valid Vehicle dto) {

        return ResponseEntity.ok(vehicleService.updateVehicle(dto));
    }
    @PutMapping(AUTHGROUP)
    public ResponseEntity<Boolean> authGroup(@RequestBody @Valid Long authId, String groupName) {

        return ResponseEntity.ok(vehicleService.authGroup(authId,groupName));
    }    @PutMapping(AUTHVEHICLE)
    public ResponseEntity<Boolean> authVehicle(@RequestBody @Valid Long authId, Long vehicleId) {

        return ResponseEntity.ok(vehicleService.authVehicle(authId,vehicleId));
    }    @PutMapping(UNAUTHGROUP)
    public ResponseEntity<Boolean> unAuthGroup(@RequestBody @Valid Long authId, String groupName) {


        return ResponseEntity.ok(vehicleService.unAuthGroup(authId,groupName));
    }    @PutMapping(UNAUTHVEHICLE)
    public ResponseEntity<Boolean> unAuthVehicle(@RequestBody @Valid Long authId, Long vehicleId) {


        return ResponseEntity.ok(vehicleService.unAuthVehicle(authId, vehicleId));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.deleteVehicle(id));
    }
}
