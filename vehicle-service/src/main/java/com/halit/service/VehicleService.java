package com.halit.service;

import com.halit.exception.VehicleManagerException;
import com.halit.repository.IVehicleRepository;
import com.halit.repository.entity.Vehicle;
import com.halit.utility.ServiceManager;
import org.springframework.stereotype.Service;
import com.halit.exception.ErrorType;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public boolean updateVehicle(Vehicle dto) {
        //Optional<Long> authId = jwtTokenManager.getUserId(postUpdateDto.getToken());

   //     if (authId.isPresent()) {
     //       UserProfilePostResponseDto dto = userManager.findbyAuthId(authId.get()).getBody();
            Optional<Vehicle> vehicle = vehicleRepository.findById(dto.getId());
            if (vehicle.isPresent()) {
                vehicle.get().setGroupId(dto.getGroupId());
                vehicle.get().setFleet(dto.getFleet());
                vehicle.get().setCompanyId(dto.getCompanyId());
                vehicle.get().setRegion(dto.getRegion());
                vehicle.get().setTag(dto.getTag());
                vehicle.get().setAuthorizedIdList(dto.getAuthorizedIdList());
                save(vehicle.get());
                return true;
            } else {

                throw new VehicleManagerException(ErrorType.VEHICLE_NOT_FOUND);
            }


      //  } else {
      //      throw new VehicleManagerException(ErrorType.INVALID_TOKEN);
      //  }

    //}
    }
    public Boolean deleteVehicle(Long vehicleId) {
        //     Optional<Long> authid = jwtTokenManager.getUserId(deletePostDto.getToken());
        //     Optional<Long> companyId = jwtTokenManager.getCompanyId(deletePostDto.getToken());
   //     if (authid.isPresent()) {
        //        UserProfilePostResponseDto dto = userManager.findbyAuthId(authid.get()).getBody();
            Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
            if (vehicle.isPresent()) {

                delete(vehicle.get());
                return true;
            } else {
                throw new VehicleManagerException(ErrorType.VEHICLE_NOT_FOUND);
            }

 //       } else {
   //         throw new VehicleManagerException(ErrorType.INVALID_TOKEN);
  //      }
    }

    public Boolean authGroup(Long vehicleId, Long groupId) {
        List<Vehicle> vehicleList = vehicleRepository.findAllByGroupId(groupId);
        vehicleList.forEach(x->x.addAuthorizedId(vehicleId));
        return true;
    }
    public Boolean authVehicle(Long authId, Long vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        vehicle.get().addAuthorizedId(authId);
        return true;
    }
    public Boolean unAuthGroup(Long authId, Long groupId) {
        List<Vehicle> vehicleList = vehicleRepository.findAllByGroupId(groupId);
        vehicleList.forEach(x->x.removeAuthorizedId(authId));
        return true;
    }
    public Boolean unAuthVehicle(Long authId, Long vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        vehicle.get().removeAuthorizedId(authId);
        return true;
    }

    public List<Vehicle> findAllByAuthorizedId(Long authId) {
        List<Vehicle> vehicleList = vehicleRepository.findAllByCompanyId(authId);
        return vehicleList.stream().filter(x-> x.getAuthorizedIdList().contains(authId)).collect(Collectors.toList());
    }
}
