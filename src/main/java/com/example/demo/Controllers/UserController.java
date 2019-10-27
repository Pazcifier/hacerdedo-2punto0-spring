/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controllers;

import com.example.demo.Entities.User;
import com.example.demo.Repositories.UserRepository;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author estudiante.fit
 */

@RestController
public class UserController {
    
    @GetMapping("/users")
    public List<User> getAll() {
        UserRepository userRepository = new UserRepository();
        return userRepository.getAll();
    }
    
    @GetMapping("/user/{id}")
    public User get(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        UserRepository userRepository = new UserRepository();
        return userRepository.get(userId);
    }
    
    @PostMapping("/users")
    public User insert(@RequestBody Map<String, String> body) {
        UserRepository userRepository = new UserRepository();
        int id = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        String last_name = body.get("last_name");
        String phone = body.get("phone");
        String password = body.get("password");
        return userRepository.insert(new User(id, name, last_name, phone, password));
    }
    
    @PatchMapping("/user/{id}")
    public User update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int userId = Integer.parseInt(id);
        UserRepository userRepository = new UserRepository();
        User u = userRepository.get(userId);
        
        if (body.get("name") != null)
            u.setName(body.get("name"));
        
        if (body.get("last_name") != null) 
            u.setLast_name(body.get("last_name"));
        
        if (body.get("phone") != null)
            u.setPhone(body.get("phone"));
        
        if (body.get("password") != null)
            u.setPassword(body.get("password"));
        
        return userRepository.update(u);
    }
    
    @DeleteMapping("/user/{id}")
    public boolean delete(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        UserRepository userRepository = new UserRepository();
        return userRepository.delete(userId);
    }
    
}
