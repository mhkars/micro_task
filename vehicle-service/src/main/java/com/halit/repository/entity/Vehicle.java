package com.halit.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tbl_vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String plate;
    private Long companyId;
    @ElementCollection
    private List<Long> authorizedIdList;
    @Column(unique = true)
    private String vehicleIdentificationNumber;
    private String tag;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String year;
    private String region;
    private String fleet;
    private String groupId;

    public void addAuthorizedId(Long value) {
        this.authorizedIdList.add(value);
    }
    public void removeAuthorizedId(Long value) {
        this.authorizedIdList.remove(value);
    }

}
