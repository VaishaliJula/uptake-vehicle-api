package com.metro.uptakevehicleapi.Repository;

import com.metro.uptakevehicleapi.Domain.Vehicle;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends ElasticsearchRepository<Vehicle, String>{

    public List<Vehicle> findByVin(String vin);

    public List<Vehicle> findByMakeOrModelOrYearOrVin(String make, String model, long year, String vin);

}
