package com.fleetmanagement.fleetmanagementapi.services;

import com.fleetmanagement.fleetmanagementapi.Dto.TrajectoriesDto;
import com.fleetmanagement.fleetmanagementapi.models.Trajectories;
import com.fleetmanagement.fleetmanagementapi.repository.ListTrajectoriesExcelRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ListTrajectoriesExcelRepository repository;
    public boolean exportToExcel(String fileName) throws IOException {
        try {

            List<Trajectories> trajectoriesList = repository.listTrajectoriesForExcel();
            List<TrajectoriesDto> listTrajectoryDto = new ArrayList<>();
            for (Trajectories trajectory : trajectoriesList) {
                listTrajectoryDto.add(new TrajectoriesDto(trajectory.getTaxi().getLicense(), trajectory.getLatitude(), trajectory.getLongitude(), trajectory.getTaxi_id(), trajectory.getDate()));
            }

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Trayectorias");

            Row headerRow = sheet.createRow(0);
            String[] columns = {"taxi_id", "license", "latitude", "longitude", "date"};
            for (int i = 0; i < columns.length; i++){
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            //  Cuerpo del Excel

            int numberOfRow = 1;
            for (TrajectoriesDto trajectoryExcel : listTrajectoryDto) {
                Row row = sheet.createRow(numberOfRow++);
                row.createCell(0).setCellValue(trajectoryExcel.getTaxi_id());
                row.createCell(1).setCellValue(trajectoryExcel.getLicense());
                row.createCell(2).setCellValue(trajectoryExcel.getLatitude());
                row.createCell(3).setCellValue(trajectoryExcel.getLongitude());
                row.createCell(4).setCellValue(trajectoryExcel.getDate().toString());
            }

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);

            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            workbook.close();
            return true;

        } catch (Exception e){
            return false;
        }

    }

}
