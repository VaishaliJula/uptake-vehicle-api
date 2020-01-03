package com.metro.uptakevehicleapi.Service;

import com.metro.uptakevehicleapi.Domain.Vehicle;
import com.metro.uptakevehicleapi.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public Iterable<Vehicle> saveVehicle(List<Vehicle> vehicles) {

        Iterable<Vehicle> vehicleIterable = vehicleRepository.saveAll(vehicles);
//        Message<List<Vehicle>> vehicleMessage = MessageBuilder.withPayload(vehicles)
//                .setHeader("topic", "Vehicles")
//                .build();
//        eventProducer.publishMessage(vehicleMessage);

        kafkaTemplate.send("Uptake-Vehicles",vehicles);

        return vehicleIterable;
    }

    @Override
    public Page<Vehicle> findAllVehicles(int pageNumber, int pageSize) {
        return vehicleRepository.findAll(PageRequest.of(pageNumber,pageSize));
    }

    @Override
    public List<Vehicle> findByEither(Vehicle vehicle) {
        return vehicleRepository.findByMakeOrModelOrYearOrVin(vehicle.getVin(),vehicle.getModel(),vehicle.getYear(),vehicle.getVin());
    }
}
