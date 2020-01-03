//package com.metro.uptakevehicleapi.kafka.producer;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.stereotype.Component;
//import org.springframework.util.concurrent.ListenableFuture;
//
//@Component
//public class EventProducer {
//
//    private static final Logger log = LogManager.getLogger(EventProducer.class);
//
//    @Autowired
//    private KafkaTemplate template;
//
//    public void publishMessage(Message message){
//
//        ListenableFuture response = template.send(message.getHeaders().get(KafkaHeaders.TOPIC).toString(), message.getPayload());
//        log.info("The Message was published to topic :: {}  and the payload is :: {} and response is :: {} ",message.getHeaders().get("topic").toString(), message.getPayload(),response.toString());
//
//    }
//
//}
