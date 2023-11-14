package com.fleetmanagement.fleetmanagementapi.services;

import com.fleetmanagement.fleetmanagementapi.Dto.TrajectoriesDto;
import com.fleetmanagement.fleetmanagementapi.models.Trajectories;
import com.fleetmanagement.fleetmanagementapi.repository.LastTrajectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@Service
public class LastTrajectoryService {
    @Autowired
    private LastTrajectoryRepository repository;
    @GetMapping("/ultima")
    public List<TrajectoriesDto> listLastTrajectoriesByTaxi(Pageable pageable) {
        Page<Trajectories> listTrajectories = repository.findLastTrajectory(pageable);
        List<TrajectoriesDto> listTrajectoryDto = new ArrayList<>();
        for (Trajectories trajectory : listTrajectories) {
            listTrajectoryDto.add(new TrajectoriesDto(trajectory.getTaxi().getLicense(), trajectory.getLatitude(), trajectory.getLongitude(), trajectory.getTaxi_id(), trajectory.getDate()));
            System.out.println(trajectory.getTaxi().getLicense());
        }
        return listTrajectoryDto;
    }
}
