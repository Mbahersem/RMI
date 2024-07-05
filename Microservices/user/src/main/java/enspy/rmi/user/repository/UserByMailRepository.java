package enspy.rmi.user.repository;

import enspy.rmi.user.entity.UserByMail;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UserByMailRepository extends CrudRepository<UserByMail, String> {
    ArrayList<UserByMail> findAll();
}
