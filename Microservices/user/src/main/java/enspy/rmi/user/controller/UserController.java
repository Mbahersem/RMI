package enspy.rmi.user.controller;

import enspy.rmi.user.entity.User;
import enspy.rmi.user.entity.UserByMail;
import enspy.rmi.user.service.UserByMailService;
import enspy.rmi.user.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
// import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserByMailService userByMailService;
    // @Autowired
    //private PulsarTemplate<UUID> pulsarTemplate;

    private static final String USER_TOPIC = "user-id";
    private static final String USER_LOG_OUT = "disconnect";

    @QueryMapping
    public UserByMail userByEmail(@Argument String email) {
        return userByMailService.getByEmail(email);
    }

    @QueryMapping
    public User getUser(@Argument UUID id) {
        return userService.getUser(id);
    }

    @MutationMapping
    public User createUser(@Argument String email, @Argument String password, @Argument String name) {
        UserByMail isUser = userByMailService.getByEmail(email);
        if(isUser != null) {
            return null;
        }
        return userService.createUser(email, password, name);
    }

    @MutationMapping
    public String loginUser(@Argument String email, @Argument String password) {
        UserByMail userByMail = userByMailService.getByEmail(email);
        User user = userService.getUser(userByMail.getUserId());
        if(user != null) {
            if(user.getUserName().equals(email) && BCrypt.checkpw(password, user.getUserPassword())) {
                try {
                    // userService.sendMessageToPulsarTopic(pulsarTemplate, USER_TOPIC, user.getUserId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return user.getUserName();
            }
        }
        return null;
    }

    @MutationMapping
    public void updateUser(@Argument UUID id, @Argument String password, @Argument String name) {
        User user = userService.getUser(id);
        if(password != null) {
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            user.setUserPassword(hashedPassword);
        } if (name != null) {
            user.setUserName(name);
        }
        userService.save(user);

    }
}

