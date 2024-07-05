package com.example.demo.service;

import lombok.Getter;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Service;

@Getter
@Service
public class IngestionConsumer {
    private boolean isApiOk;
    private static final String API_EXIST_TOPIC = "api-exist";

    @PulsarListener(
            subscriptionName = "api-exist-subscription",
            topics = API_EXIST_TOPIC,
            subscriptionType = SubscriptionType.Shared
    )
    public void apiExistenceTopicListener(Boolean rep) {
        this.isApiOk = rep;
    }
}
