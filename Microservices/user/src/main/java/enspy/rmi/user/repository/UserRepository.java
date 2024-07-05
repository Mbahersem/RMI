package enspy.rmi.user.repository;

import enspy.rmi.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    ArrayList<User> findAll();
}
