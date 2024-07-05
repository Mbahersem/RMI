package enspy.rmi.user.service;

import enspy.rmi.user.entity.User;
import enspy.rmi.user.entity.UserByMail;
import enspy.rmi.user.repository.UserByMailRepository;
import enspy.rmi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserByMailService {
    @Autowired
    private UserByMailRepository userByMailRepository;

    public ArrayList<UserByMail> findAll() {
        return userByMailRepository.findAll();
    }

    public UserByMail getByEmail(String email) {
        ArrayList<UserByMail> userByMails = userByMailRepository.findAll();
        for(UserByMail user: userByMails) {
            if(user.getUserMail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
