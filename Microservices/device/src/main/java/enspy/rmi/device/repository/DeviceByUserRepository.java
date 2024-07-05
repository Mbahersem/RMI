package enspy.rmi.device.repository;

import enspy.rmi.device.entity.DeviceByUser;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DeviceByUserRepository extends CrudRepository<DeviceByUser, String> {
    ArrayList<DeviceByUser> findAll();
}
