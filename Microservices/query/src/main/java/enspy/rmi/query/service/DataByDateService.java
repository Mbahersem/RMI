package enspy.rmi.query.service;

import enspy.rmi.query.entity.DataByDate;
import enspy.rmi.query.repository.DataByDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataByDateService {
    @Autowired
    private DataByDateRepository dataByDateRepository;

    private ArrayList<DataByDate> findAll() {
        return dataByDateRepository.findAll();
    }
}
