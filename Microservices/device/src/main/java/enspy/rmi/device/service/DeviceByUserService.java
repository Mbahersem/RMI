package enspy.rmi.device.service;

import enspy.rmi.device.entity.DeviceByUser;
import enspy.rmi.device.repository.DeviceByUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class DeviceByUserService {
    @Autowired
    private DeviceByUserRepository deviceByUserRepository;

    public ArrayList<DeviceByUser> findAll (UUID id) {
        ArrayList<DeviceByUser> devices = deviceByUserRepository.findAll();
        ArrayList<DeviceByUser> toSend = new ArrayList<>();

        for(DeviceByUser device: devices) {
            if (device.getUserId().toString().equals(id.toString())) {
                toSend.add(device);
            }
        }
        return toSend;
    }
}
