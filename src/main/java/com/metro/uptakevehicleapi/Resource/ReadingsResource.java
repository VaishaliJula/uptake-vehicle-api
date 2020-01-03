package com.metro.uptakevehicleapi.Resource;

import com.metro.uptakevehicleapi.Domain.Readings;
import com.metro.uptakevehicleapi.Domain.Vehicle;
import com.metro.uptakevehicleapi.Service.ReadingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/readings")
public class ReadingsResource {

    @Autowired
    private ReadingsService readingsService;

    @PostMapping(value = "ingestReadings")
    public void ingestVehicleReading(@RequestBody Readings readings){
        readingsService.ingestReadings(readings);
    }

    @GetMapping(value = "/getAllReadings")
    public Page<Readings> getAllReadings(@RequestParam int  pageNumber, @RequestParam int pageSize) {
        return readingsService.findAllReadings(pageNumber,pageSize);
    }
}
