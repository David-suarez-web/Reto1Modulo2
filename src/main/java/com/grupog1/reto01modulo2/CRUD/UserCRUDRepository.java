package com.grupog1.reto01modulo2.CRUD;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.grupog1.reto01modulo2.Model.User;

public interface UserCRUDRepository extends CrudRepository<User, Integer> {
   public Optional<User> findByEmail(String email);

   public Optional<User>findByEmailAndPassword(String email, String password);
}
