package com.grupog1.reto01modulo2.Controller;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.grupog1.reto01modulo2.Service.UserService;
import com.grupog1.reto01modulo2.Model.User;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/new")   //ip:puerto/api/user/new
    @ResponseStatus(HttpStatus.CREATED)  //201
    public User save(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll(); 
    }
    @GetMapping("/{email}")         //localhost..../api/user/correo@usa.edu.co
    public boolean emailExists(@PathVariable String email){
        return userService.emailExists(email);
    }

    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable String email, @PathVariable String password){
        return userService.authUser(email, password);
    }
    
}
