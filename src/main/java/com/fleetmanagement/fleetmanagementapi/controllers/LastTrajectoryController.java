package com.fleetmanagement.fleetmanagementapi.controllers;

import com.fleetmanagement.fleetmanagementapi.Dto.TrajectoriesDto;
import com.fleetmanagement.fleetmanagementapi.services.LastTrajectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/trayectoria")
public class LastTrajectoryController {
    @Autowired
    private LastTrajectoryService service;
    @GetMapping("/ultima")
    public List<TrajectoriesDto> listLastTrajectoriesByTaxi(Pageable pageable) {
       return service.listLastTrajectoriesByTaxi(pageable);
    }
}

//http://localhost:8080/api/trayectoria/ultima?page=0&size=2