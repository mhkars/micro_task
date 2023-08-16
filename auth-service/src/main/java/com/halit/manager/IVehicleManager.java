package com.halit.manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.halit.constants.ApiUrls.*;

@FeignClient(url = "http://localhost:8091964335/vehicle",name = "user-service-userprofile",decode404 = true)
public interface IVehicleManager {



//    @PostMapping(CREATE)
//    public ResponseEntity<Boolean> createUser(@RequestBody NewCreateUserDto dto);
//    @PostMapping(ACTIVATESTATUS)
//    public ResponseEntity<Boolean> activateStatus(@RequestBody ActivateReguestDto dto);

    @PostMapping(ACTIVATESTATUSBYID)
    public ResponseEntity<Boolean> activateStatus(@PathVariable Long authid);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id);

}
