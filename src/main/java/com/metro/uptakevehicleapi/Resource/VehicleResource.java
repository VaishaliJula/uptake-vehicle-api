package com.metro.uptakevehicleapi.Resource;

import com.metro.uptakevehicleapi.Domain.Vehicle;
import com.metro.uptakevehicleapi.Repository.VehicleRepository;
import com.metro.uptakevehicleapi.Service.VehicleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(value = "/vehicle")
@CrossOrigin(origins = "http://mocker.ennate.academy")
public class VehicleResource {

    private static final Logger LOGGER = LogManager.getLogger(VehicleResource.class);

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleRepository vehiclerepository;

    @PutMapping(value= "/ingestVehicles")
    public String saveVehicle(@RequestBody List<Vehicle> vehicleList) {
        vehicleService.saveVehicle(vehicleList);
        return "Records saved in the elastic search.";
    }

    @GetMapping(value = "/getAllVehicles")
    public Page<Vehicle> getAllVehicles(@RequestParam int  pageNumber, @RequestParam int pageSize) {
        return vehicleService.findAllVehicles(pageNumber,pageSize);
    }

    @GetMapping(value = "/findBytest")
    public List<Vehicle> testGet(String vin, String model, String make, long year) {
        return vehiclerepository.findByMakeOrModelOrYearOrVin(make,model,year,vin);
    }

    @PostConstruct
    public void test(){
        List<Vehicle> res = vehiclerepository.findByMakeOrModelOrYearOrVin("","",0,"2T1BU4EE4DC919097");
        res.forEach(vehicle -> {
            System.out.println(vehicle.toString());
        });
        System.out.println(res.size()+"size is");
    }

}
