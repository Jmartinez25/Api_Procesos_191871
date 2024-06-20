package com.api1.crudtienda.user.services;

import com.api1.crudtienda.RequestResponseGeneric.AlreadyExists;
import com.api1.crudtienda.enums.Messages;
import com.api1.crudtienda.user.models.UserModel;
import com.api1.crudtienda.user.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserService {
    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void createUser(UserModel user) {
        Optional<User> userFindByEmail = userRepository.findByEmail(user.getEmail());
        if (userFindByEmail.isPresent()) {
            throw new AlreadyExists(Messages.USER_EMAIL_EXISTS.getMessage());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //userRepository.save(user);
    }
}
