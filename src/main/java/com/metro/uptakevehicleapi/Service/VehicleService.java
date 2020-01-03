package com.metro.uptakevehicleapi.Service;

import com.metro.uptakevehicleapi.Domain.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VehicleService {

    public Iterable<Vehicle> saveVehicle(List<Vehicle> vehicles);

    public Page<Vehicle> findAllVehicles(int pageNumber, int pageSize);

    List<Vehicle> findByEither(Vehicle vehicle);
}
