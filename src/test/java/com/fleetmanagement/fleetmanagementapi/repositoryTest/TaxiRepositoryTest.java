package com.fleetmanagement.fleetmanagementapi.repositoryTest;

import com.fleetmanagement.fleetmanagementapi.models.Taxi;
import com.fleetmanagement.fleetmanagementapi.repository.TaxiRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TaxiRepositoryTest {
    @Autowired
    private TaxiRepository repository;

    @Test
    public void TaxiRepository_GetAll(){
        Taxi taxi = Taxi.builder()
                .id(1245)
                .license("EEII1122")
                .build();
        Taxi taxi2 = Taxi.builder().id(6789).license("AAEE2244").build();

        repository.save(taxi);
        repository.save(taxi2);

        List<Taxi> taxiList = repository.findAll();

        Assertions.assertThat(taxiList).isNotNull();
        Assertions.assertThat(taxiList.size()).isEqualTo(2);
    }
}
