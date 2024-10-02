package com.thaisrosa.economy.repository;

import com.thaisrosa.economy.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

    User findByEmail(String email);

    User findByNome(String nome);
}
