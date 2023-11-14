package com.fleetmanagement.fleetmanagementapi.repository;

import com.fleetmanagement.fleetmanagementapi.models.Trajectories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListTrajectoriesExcelRepository extends JpaRepository<Trajectories, Integer> {
    @Query(value = "SELECT taxis.id, taxis.license, trajectories.taxi_id, trajectories.date, trajectories.latitude, trajectories.longitude " +
            "FROM taxis " +
            "JOIN trajectories ON taxis.id = trajectories.taxi_id ", nativeQuery = true)
    List<Trajectories> listTrajectoriesForExcel();
}
