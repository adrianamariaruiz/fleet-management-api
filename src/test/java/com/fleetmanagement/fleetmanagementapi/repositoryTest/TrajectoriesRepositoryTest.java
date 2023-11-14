package com.fleetmanagement.fleetmanagementapi.repositoryTest;

import com.fleetmanagement.fleetmanagementapi.models.Taxi;
import com.fleetmanagement.fleetmanagementapi.models.Trajectories;
import com.fleetmanagement.fleetmanagementapi.repository.TrajectoriesRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TrajectoriesRepositoryTest {
    @Autowired
    private TrajectoriesRepository repository;

    @Test
    public void Trajectories_findByDateAndId (){

        LocalDateTime dateTime = LocalDateTime.parse("2008-02-02T14:08:08", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Date staticDatePrueba = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());

        Trajectories trajectory1 = Trajectories.builder()
                .date(staticDatePrueba)
                .latitude(116.41167)
                .longitude(39.90951)
                .taxi_id(6000)
                .build();

        Trajectories trajectory2 = Trajectories.builder()
                .date(staticDatePrueba)
                .latitude(41.8781)
                .longitude(-87.6298)
                .taxi_id(6001)
                .build();

        repository.save(trajectory1);
        repository.save(trajectory2);


        Page<Trajectories> trajectories = repository.findTrajectoriesByTaxiIdAndDate(6000, "2008-02-02", PageRequest.of(0, 2));

        Assertions.assertThat(trajectories).isNotNull();
        Assertions.assertThat(trajectories.getContent()).isNotEmpty();

    }
}
