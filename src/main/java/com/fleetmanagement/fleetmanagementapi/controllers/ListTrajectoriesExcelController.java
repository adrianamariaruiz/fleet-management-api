package com.fleetmanagement.fleetmanagementapi.controllers;

import com.fleetmanagement.fleetmanagementapi.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/exportToExcel")
public class ListTrajectoriesExcelController {
    @Autowired
    private ReportService reportService;
    @GetMapping()
    public String exportToExcel() throws IOException {
        if (reportService.exportToExcel("D:\\reporteTrayectorias.xlsx")) {
            return "Reporte generado correctamente ✔";
        } else {
            return "Ha ocurrido un error con la descarga del archivo ❌";
        }
    }



}
