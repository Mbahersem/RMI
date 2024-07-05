package com.example.demo.service;

import com.example.demo.repository.DataByTokenRepository;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IngestionService {
    @Autowired
    private DataByTokenRepository dataByTokenRepository;

    public void sendMessageToPulsarTopic(PulsarTemplate<String> pulsarTemplate, String topic, String api) throws PulsarClientException {
        pulsarTemplate.send(topic, api);
    }
}
