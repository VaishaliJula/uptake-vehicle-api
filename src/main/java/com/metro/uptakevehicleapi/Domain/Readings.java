package com.metro.uptakevehicleapi.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.Map;

@Document(indexName = "metro", type = "readings")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Readings {

    @Id
    private String vin;
    private double latitude;
    private double longitude;
    private Date timestamp;
    private float fuelVolume;
    private float speed;
    private int engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private int engineRpm;
    private Tires tires;
    
}

