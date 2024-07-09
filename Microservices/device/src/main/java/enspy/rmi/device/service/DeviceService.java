package enspy.rmi.device.service;

import enspy.rmi.device.entity.Device;
import enspy.rmi.device.entity.DeviceByName;
import enspy.rmi.device.entity.DeviceByUser;
import enspy.rmi.device.entity.Info;
import enspy.rmi.device.repository.DeviceByNameRepository;
import enspy.rmi.device.repository.DeviceByUserRepository;
import enspy.rmi.device.repository.DeviceRepository;
// import org.apache.pulsar.client.api.PulsarClientException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private DeviceByUserRepository deviceByUserRepository;
    @Autowired
    private DeviceByNameRepository deviceByNameRepository;

    DeviceConsumer deviceConsumer = new DeviceConsumer();

    public Device getDevice(UUID id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public Device createDevice(String deviceName, String support, String type) {
        Device device = new Device(deviceName, support, type);
        DeviceByUser deviceByUser = new DeviceByUser(deviceConsumer.getUserId(), deviceName, device.getDeviceId());
        DeviceByName deviceByName = new DeviceByName(deviceName, deviceConsumer.getUserId(), device.getDeviceId());
        if(support.equals("WiFi")) {
            device.setApi(BCrypt.hashpw(device.getDeviceId() + device.getDeviceName(), BCrypt.gensalt()));
        }
        deviceRepository.save(device);
        deviceByUserRepository.save(deviceByUser);
        deviceByNameRepository.save(deviceByName);
        return device;
    }

    public Device deleteDeviceById(UUID id) {
        Device deviceToDelete = deviceRepository.findById(id).orElse(null);
        if(deviceToDelete != null) {
            ArrayList<DeviceByName> deviceByNames = deviceByNameRepository.findAll();
            for(DeviceByName deviceByName: deviceByNames) {
                if(deviceByName.getDeviceId().toString().equals(deviceToDelete.getDeviceId().toString())) {
                    deviceByNameRepository.delete(deviceByName);
                }
            }
            ArrayList<DeviceByUser> deviceByUsers = deviceByUserRepository.findAll();
            for(DeviceByUser deviceByUser: deviceByUsers) {
                if(deviceByUser.getDeviceId().toString().equals(deviceToDelete.getDeviceId().toString())) {
                    deviceByUserRepository.delete(deviceByUser);
                }
            }
            deviceRepository.delete(deviceToDelete);
        }
        return deviceToDelete;
    }

//    public void sendMessageToPulsarTopic(PulsarTemplate<Info> pulsarTemplate, String topic, Info info) throws PulsarClientException {
//        pulsarTemplate.send(topic, info);
//    }

}
