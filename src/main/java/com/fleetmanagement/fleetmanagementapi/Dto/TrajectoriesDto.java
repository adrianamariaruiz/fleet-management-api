package com.fleetmanagement.fleetmanagementapi.Dto;


import java.util.Date;

public class TrajectoriesDto {
    private String license;
    private double latitude;
    private double longitude;
    private Date date;
    private Integer taxi_id;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Integer getTaxi_id() {
        return taxi_id;
    }

    public void setTaxi_id(Integer taxi_id) {
        this.taxi_id = taxi_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TrajectoriesDto(String license, double latitude, double longitude, Integer taxi_id, Date date) {
        this.license = license;
        this.latitude = latitude;
        this.longitude = longitude;
        this.taxi_id = taxi_id;
        this.date = date;
    }
}
