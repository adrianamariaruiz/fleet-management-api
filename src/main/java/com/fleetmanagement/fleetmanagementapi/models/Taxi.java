package com.fleetmanagement.fleetmanagementapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="taxis")
public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String license;

    @OneToMany(mappedBy = "taxi")
    private List<Trajectories> trajectories;


    public Taxi (Integer id, String license) {
        this.id = id;
        this.license = license;
    }

}
