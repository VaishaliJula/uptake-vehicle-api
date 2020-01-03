package com.metro.uptakevehicleapi.Service;

import com.metro.uptakevehicleapi.Domain.Readings;
import com.metro.uptakevehicleapi.Domain.Vehicle;
import com.metro.uptakevehicleapi.Repository.ReadingsRepository;
import com.metro.uptakevehicleapi.Repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Optional;

@Service
@Slf4j
public class ReadingsServiceImpl implements ReadingsService{
    private static final Logger log = LogManager.getLogger(ReadingsService.class);

    @Autowired
    ReadingsRepository readingsRepository;

    @Autowired
    private KafkaTemplate template;

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public Readings ingestReadings(Readings readings) {


        Optional<Vehicle> vehicleVin = vehicleRepository.findById(readings.getVin());
        log.info("Vehicle present in db:: {}", readings.getVin());
        if (!vehicleVin.isPresent()) {
            log.info("VIN doesn't exists in ES, readings can't be updated");
            return null;

        }else
        {
            Readings reading = readingsRepository.save(readings);
            ListenableFuture response = template.send("Uptake-Readings", readings);
            log.info("Message published  to kafka is {} :", response);

            return reading;
        }
        //        Message<Readings> readingsMessage = MessageBuilder.withPayload(readings)
//                .setHeader(KafkaHeaders.TOPIC, "Uptake-Readings")
//                .build();
//        List<Readings> readingsList =  new ArrayList<>();
//        readingsList.add(readings);

//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode readingsList = objectMapper.valueToTree(readings);
//        log.info("The Message was published to topic :: {}  and the payload is :: {} and response is :: {} ",message.getHeaders().get("topic").toString(), message.getPayload(),response.toString());



    }

    @Override
    public Page<Readings> findAllReadings(int pageNumber, int pageSize) {
        return readingsRepository.findAll(PageRequest.of(pageNumber,pageSize));
    }

}
