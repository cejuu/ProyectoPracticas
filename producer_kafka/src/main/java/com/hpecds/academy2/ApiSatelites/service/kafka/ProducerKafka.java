package com.hpecds.academy2.ApiSatelites.service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerKafka {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    public void sendMessageToKafka(String message) {
        int numRetries = 3;
        int retryCount = 0;
        boolean sent = false;

        while (!sent && retryCount < numRetries) {
            try {
                kafkaTemplate.send(topic, message);
                sent = true;
            } catch (Exception e) {
                System.out.println("Error sending message to Kafka: " + e.getMessage());
                retryCount++;
                if (retryCount >= numRetries) {
                    System.out.println("Maximum retry limit reached, giving up.");
                } else {
                    System.out.println("Retrying in 5 seconds...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

}
