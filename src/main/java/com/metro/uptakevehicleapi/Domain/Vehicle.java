package com.metro.uptakevehicleapi.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName= "rail", type= "vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehicle {

    @Id
    private String vin;
    private String make;
    private String model;
    private int year;
    private int readlineRpm;
    private int maxFuelVolume;
    private Date lastServiceDate;

}
