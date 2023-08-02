package com.grupog1.reto01modulo2.Service;

import com.grupog1.reto01modulo2.Service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupog1.reto01modulo2.Model.User;
import com.grupog1.reto01modulo2.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }
    
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    

    public User save(User user){
        if (!emailExists(user.getEmail())){
            if(validAttributes(user)){
                return  userRepository.save(user);
            }
        }
        return user;
    }
    public boolean emailExists(String email){
        Optional<User> usuarioEncontrado = userRepository.findByEmail(email);
        return usuarioEncontrado.isPresent();
    }

    public boolean validAttributes(User user){
        return (user.getEmail()!=null && user.getPassword()!=null && user.getName()!=null);  
    }
    public User authUser(String email, String password){
        Optional<User> usuarioEncontrado = userRepository.findByEmailAndPassword(email, password);
        if(usuarioEncontrado.isPresent()){
            return usuarioEncontrado.get();
        } else{
            return new User( null, email, password,"NO DEFINIDO" );
        }
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
