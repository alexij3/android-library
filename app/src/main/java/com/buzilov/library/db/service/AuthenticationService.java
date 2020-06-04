package com.buzilov.library.db.service;

import com.buzilov.library.db.repository.UserRepository;
import com.buzilov.library.model.User;

public class AuthenticationService {

    public User authenticateUser(String email, String password) {
        final UserRepository userRepository = new UserRepository();
        final User user = userRepository.getByEmailAndPassword(email, password);
        return user;
    }

}
