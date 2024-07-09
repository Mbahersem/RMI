package enspy.rmi.user.service;

import enspy.rmi.user.entity.User;
import enspy.rmi.user.entity.UserByMail;
import enspy.rmi.user.repository.UserByMailRepository;
import enspy.rmi.user.repository.UserRepository;
// import org.apache.pulsar.client.api.PulsarClientException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserByMailRepository userByMailRepository;

    public ArrayList<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getUser(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User createUser(String email, String password, String name) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(email, name, hashedPassword);
        userRepository.save(user);

        UserByMail userByMail = new UserByMail(email, user.getUserId());
        userByMailRepository.save(userByMail);

        return user;
    }

//    public void sendMessageToPulsarTopic(PulsarTemplate<UUID> pulsarTemplate, String topic, UUID id) throws PulsarClientException {
//        pulsarTemplate.send(topic, id);
//    }
}
