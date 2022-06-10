package com.example.selfcert.services;

import com.example.selfcert.repositories.api.IDSRepository;
import com.example.selfcert.repositories.db.UserRepository;
import com.example.selfcert.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    private IDSRepository idsRepository;
    private UserRepository userRepository;

    @Autowired
    public UserService(IDSRepository idsRepository, UserRepository userRepository) {
        this.idsRepository = idsRepository;
        this.userRepository = userRepository;
    }

    public User getUserInformation(Long id) {
        User user = userRepository.findUser(id);
        Optional<Date> lastLoggedIn = idsRepository.getLastLoggedInTime(user.getEmail());
        if (lastLoggedIn.isPresent()) {
            user.setLastLoggedIn(lastLoggedIn.get());
            final Date today = new Date();
            user.setRecentlyActive(((today.getTime() - user.getLastLoggedIn().getTime()) / (1000 * 60 * 60 * 24)) < 3); // active in last 3 days
        }
        return user;
    }
}
