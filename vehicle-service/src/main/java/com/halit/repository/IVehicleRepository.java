package com.halit.repository;

import com.halit.repository.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAllByGroupId(Long id);

    List<Vehicle> findAllByCompanyId(Long companyId);


}
