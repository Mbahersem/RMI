package enspy.rmi.device.repository;

import enspy.rmi.device.entity.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface DeviceRepository extends CrudRepository<Device, UUID> {
    ArrayList<Device> findAll();
}
