package enspy.rmi.device.service;

import enspy.rmi.device.entity.DeviceByName;
import enspy.rmi.device.repository.DeviceByNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceByNameService {
    @Autowired
    private DeviceByNameRepository deviceByNameRepository;

    public DeviceByName getDeviceByName(String name) {
        DeviceByName device = deviceByNameRepository.findByDeviceName(name);
        if(device != null) {
            return device;
        }
        return null;
    }
}
