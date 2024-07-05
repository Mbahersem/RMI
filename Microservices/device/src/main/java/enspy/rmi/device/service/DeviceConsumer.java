package enspy.rmi.device.service;

import enspy.rmi.device.entity.Device;
import enspy.rmi.device.entity.DeviceByUser;
import lombok.Getter;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@Getter
public class DeviceConsumer {
    @Autowired
    PulsarTemplate<Boolean> template;

    private static final String USER_TOPIC = "user-id";
    private static final String EXIST_TOPIC = "exist-api";
    private static final String API_EXIST_TOPIC = "api-exist";

    private UUID userId;

    @PulsarListener(
            subscriptionName = "user-topic-subscription",
            topics = USER_TOPIC,
            subscriptionType = SubscriptionType.Shared
    )
    public void userTopicListener(UUID id) {
        this.userId = id;
    }

    @PulsarListener(
            subscriptionName = "exist-api-subscription",
            topics = EXIST_TOPIC,
            subscriptionType = SubscriptionType.Shared
    )
    public void apiExistTopicListener(String api) {
        DeviceByUserService deviceByUserService = new DeviceByUserService();
        DeviceService deviceService = new DeviceService();
        ArrayList<DeviceByUser> deviceByUsers = deviceByUserService.findAll(this.userId);
        for (DeviceByUser deviceByUser: deviceByUsers) {
            Device device = deviceService.getDevice(deviceByUser.getUserId());
            if(device.getApi().equals(api)) {
                try {
                    template.send(API_EXIST_TOPIC, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            template.send(API_EXIST_TOPIC, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
