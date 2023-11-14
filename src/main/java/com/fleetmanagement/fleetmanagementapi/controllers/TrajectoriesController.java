package com.fleetmanagement.fleetmanagementapi.controllers;
import com.fleetmanagement.fleetmanagementapi.models.Trajectories;
import com.fleetmanagement.fleetmanagementapi.repository.LastTrajectoryRepository;
import com.fleetmanagement.fleetmanagementapi.repository.TrajectoriesRepository;
import com.fleetmanagement.fleetmanagementapi.services.TrajectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
@CrossOrigin
@RestController
@RequestMapping("api/trayectoria")
public class TrajectoriesController {
    @Autowired
    private TrajectoriesService service;

    @GetMapping()
    public Page<Trajectories> getTaxiTrajectories(@RequestParam("taxiId") Integer taxiId, @RequestParam("date") String date, Pageable pageable) {
        return service.getTaxiTrajectories(taxiId, date, pageable);
    }
}

//http://localhost:8080/api/trayectoria?taxiId=6000&date=2008-02-03


