package com.fleetmanagement.fleetmanagementapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "trajectories")
public class Trajectories {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date")
    private Date date;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "taxi_id", insertable = false, updatable = false)
    private Integer taxi_id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taxi_id")
    @JsonIgnore
    private Taxi taxi;



}
