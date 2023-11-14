package com.fleetmanagement.fleetmanagementapi.repository;

import com.fleetmanagement.fleetmanagementapi.models.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LastTrajectoryRepository extends JpaRepository<Trajectories, Integer> {

    @Query(value = "SELECT DISTINCT ON (trajectories.taxi_id) taxis.id, taxis.license, trajectories.taxi_id, trajectories.date, trajectories.latitude, trajectories.longitude " +
            "FROM taxis " +
            "JOIN trajectories ON taxis.id = trajectories.taxi_id " +
            "ORDER BY trajectories.taxi_id, trajectories.date DESC ", nativeQuery = true)
    Page<Trajectories> findLastTrajectory(Pageable pageable);

}
