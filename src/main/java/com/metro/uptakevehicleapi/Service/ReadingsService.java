package com.metro.uptakevehicleapi.Service;

import com.metro.uptakevehicleapi.Domain.Readings;
import com.metro.uptakevehicleapi.Domain.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface ReadingsService {

    Readings ingestReadings(Readings readings);

    Page<Readings> findAllReadings(int pageNumber, int pageSize);
}
