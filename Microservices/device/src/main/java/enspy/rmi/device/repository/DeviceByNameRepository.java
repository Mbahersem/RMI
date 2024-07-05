package enspy.rmi.device.repository;

import enspy.rmi.device.entity.DeviceByName;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DeviceByNameRepository extends CrudRepository<DeviceByName, String> {
    ArrayList<DeviceByName> findAll();
    DeviceByName findByDeviceName(String name);
}
