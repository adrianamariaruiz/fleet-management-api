package com.fleetmanagement.fleetmanagementapi.repository;
import com.fleetmanagement.fleetmanagementapi.models.Trajectories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface TrajectoriesRepository extends JpaRepository<Trajectories, Integer> {

    @Query(value = "SELECT * " +
            "FROM trajectories t " +
            "WHERE t.taxi_id = :taxiId AND to_char(t.date, 'YYYY-MM-DD') = :date", nativeQuery = true)
    Page<Trajectories> findTrajectoriesByTaxiIdAndDate(@Param("taxiId") Integer taxiId, @Param("date") String date, Pageable pageable);

}
