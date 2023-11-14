package com.fleetmanagement.fleetmanagementapi.services;

import com.fleetmanagement.fleetmanagementapi.models.Trajectories;
import com.fleetmanagement.fleetmanagementapi.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TrajectoriesService {
    @Autowired
    private TrajectoriesRepository repository;

    public Page<Trajectories> getTaxiTrajectories(@RequestParam("taxiId") Integer taxiId, @RequestParam("date") String date, Pageable pageable) {
        return repository.findTrajectoriesByTaxiIdAndDate(taxiId, date, pageable);
    }
}
