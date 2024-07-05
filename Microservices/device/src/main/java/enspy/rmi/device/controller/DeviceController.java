package enspy.rmi.device.controller;

import enspy.rmi.device.entity.Device;
import enspy.rmi.device.entity.DeviceByName;
import enspy.rmi.device.entity.DeviceByUser;
import enspy.rmi.device.entity.Info;
import enspy.rmi.device.service.DeviceByNameService;
import enspy.rmi.device.service.DeviceByUserService;
import enspy.rmi.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.UUID;

@Controller
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private DeviceByNameService deviceByNameService;
    @Autowired
    private DeviceByUserService deviceByUserService;
    @Autowired
    private PulsarTemplate<Info> pulsarTemplate;

    private static final String DEVICE_TOPIC = "devices_info";

    @QueryMapping
    public ArrayList<DeviceByUser> getDevicesByUser(@Argument UUID userId) {
        return deviceByUserService.findAll(userId);
    }

    @QueryMapping
    public Device getDevice(@Argument UUID deviceId) {
        return deviceService.getDevice(deviceId);
    }

    @QueryMapping
    public DeviceByName getDeviceByName(@Argument String deviceName) {
        return deviceByNameService.getDeviceByName(deviceName);
    }

    @MutationMapping
    public Device createDevice(@Argument String deviceName, @Argument String support, @Argument String type) {
        DeviceByName isDevice = deviceByNameService.getDeviceByName(deviceName);
        if(isDevice != null) {
            return null;
        }
        Device device = deviceService.createDevice(deviceName, support, type);
        try {
            Info info = new Info(device.getDeviceId(), device.getApi());
            deviceService.sendMessageToPulsarTopic(pulsarTemplate, DEVICE_TOPIC, info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return device;
    }

    @MutationMapping
    public Device deleteDeviceById(@Argument UUID deviceId) {
        return deviceService.deleteDeviceById(deviceId);
    }
}
