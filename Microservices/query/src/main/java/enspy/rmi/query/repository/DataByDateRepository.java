package enspy.rmi.query.repository;

import enspy.rmi.query.entity.DataByDate;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface DataByDateRepository extends CrudRepository<DataByDate, String> {
    ArrayList<DataByDate> findAll();
}
