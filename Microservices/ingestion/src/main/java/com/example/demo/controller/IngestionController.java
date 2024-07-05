package com.example.demo.controller;

import com.example.demo.service.IngestionConsumer;
import com.example.demo.service.IngestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class IngestionController {
    @Autowired
    private IngestionService ingestionService;
    @Autowired
    private PulsarTemplate<String> pulsarTemplate;

    private static final String EXIST_TOPIC = "exist-api";

    @MutationMapping
    public void insertData(@Argument String api) {
        try {
            ingestionService.sendMessageToPulsarTopic(pulsarTemplate, EXIST_TOPIC, api);
            IngestionConsumer ingestionConsumer = new IngestionConsumer();
            if(ingestionConsumer.isApiOk()) {

            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
