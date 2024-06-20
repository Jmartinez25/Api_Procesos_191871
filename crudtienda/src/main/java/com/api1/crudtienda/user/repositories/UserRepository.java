package com.api1.crudtienda.user.repositories;

import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    List<User> findByBirthday(LocalDate birthday);
    Optional<User> findByEmailAndIdNot(String email, Long id);
}
