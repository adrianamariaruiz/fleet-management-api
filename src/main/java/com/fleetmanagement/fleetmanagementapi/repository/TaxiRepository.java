package com.fleetmanagement.fleetmanagementapi.repository;

import com.fleetmanagement.fleetmanagementapi.models.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxi, Integer> {
}
