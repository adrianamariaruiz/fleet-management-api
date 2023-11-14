package com.fleetmanagement.fleetmanagementapi.controllers;
import com.fleetmanagement.fleetmanagementapi.models.Taxi;
import com.fleetmanagement.fleetmanagementapi.services.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("api/taxis")
public class TaxiController {
    @Autowired
    private TaxiService service;

    @GetMapping()
    public Page<Taxi> taxi(Pageable pageable){
        return service.taxi(pageable);
    }
}

