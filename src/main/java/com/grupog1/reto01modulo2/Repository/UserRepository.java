package com.grupog1.reto01modulo2.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupog1.reto01modulo2.CRUD.UserCRUDRepository;
import com.grupog1.reto01modulo2.Model.User;


@Repository
public class UserRepository {

      @Autowired
    private UserCRUDRepository userCRUDRepository;

    public List<User> getAll(){

        return (List<User>) userCRUDRepository.findAll();
    }


    public Optional<User> getUser(int id){
        return userCRUDRepository.findById(id);
    }

    public User save(User user){
        return userCRUDRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userCRUDRepository.findByEmail(email);
    }

    public Optional<User> findByEmailAndPassword(String email, String password ){
        return userCRUDRepository.findByEmailAndPassword(email, password);
    }

    public void delete(User user){
        userCRUDRepository.delete(user);
    }


    public UserCRUDRepository getUserCRUDRepository() {
        return userCRUDRepository;
    }


    public void setUserCRUDRepository(UserCRUDRepository userCRUDRepository) {
        this.userCRUDRepository = userCRUDRepository;
    }

}
  
    