package com.example.selfcert.services;

import com.example.selfcert.repositories.api.TimeServerGateway;
import com.example.selfcert.repositories.db.UserRepository;
import com.example.selfcert.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    private TimeServerGateway timeServerGateway;
    private UserRepository userRepository;

    @Autowired
    public UserService(TimeServerGateway timeServerGateway, UserRepository userRepository) {
        this.timeServerGateway = timeServerGateway;
        this.userRepository = userRepository;
    }

    public User getUserInformation(Long id) {
        User user = userRepository.findUser(id);

        Optional<Date> userTime = timeServerGateway.getDate(user.getEmail());
        if (userTime.isPresent()) {
            user.setLastLoggedIn(userTime.get());
            final Date today = new Date();
            user.setRecentlyActive(((today.getTime() - user.getLastLoggedIn().getTime()) / (1000 * 60 * 60 * 24)) < 3); // active in last 3 days
        } else {
            user.setRecentlyActive(false);
        }

        return user;
    }
}
