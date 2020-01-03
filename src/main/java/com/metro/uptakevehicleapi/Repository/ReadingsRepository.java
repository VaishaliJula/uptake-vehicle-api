package com.metro.uptakevehicleapi.Repository;

import com.metro.uptakevehicleapi.Domain.Readings;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingsRepository extends ElasticsearchRepository<Readings,String> {
}
