package com.coffeebreak.coffeebreak.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coffeebreak.coffeebreak.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	  List<User> findByCpf(String cpf);
	  List<User> findByAlimento(String alimento);
	  List<User> findByEmail(String email);
}