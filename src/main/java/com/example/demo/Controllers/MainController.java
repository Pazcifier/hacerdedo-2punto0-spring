/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controllers;

import com.example.demo.Entities.Friend;
import com.example.demo.Entities.User;
import com.example.demo.Repositories.FriendRepository;
import com.example.demo.Repositories.UserRepository;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author estudiante.fit
 */

@RestController
public class MainController {
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        UserRepository userRepository = new UserRepository();
        return userRepository.getAll();
    }
    
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        UserRepository userRepository = new UserRepository();
        return userRepository.get(userId);
    }
    
    @PostMapping("/users")
    public User insertUser(@RequestBody Map<String, String> body) {
        UserRepository userRepository = new UserRepository();
        int id = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        String last_name = body.get("last_name");
        String phone = body.get("phone");
        String password = body.get("password");
        return userRepository.insert(new User(id, name, last_name, phone, password));
    }
    
    @PatchMapping("/user/{id}")
    public User updateUser(@PathVariable String id, @RequestBody Map<String, String> body) {
        int userId = Integer.parseInt(id);
        UserRepository userRepository = new UserRepository();
        User u = userRepository.get(userId);
            
        u.setName(body.get("name"));
        u.setLast_name(body.get("last_name"));
        u.setPhone(body.get("phone"));
        u.setPassword(body.get("password"));
        
        return userRepository.update(u);
    }
    
    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        UserRepository userRepository = new UserRepository();
        User u = userRepository.get(userId);
        
        return userRepository.delete(u);
    }
    
    @GetMapping("/user/{id}/friends")
    public List<Friend> getAllFriendsFromUser(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        FriendRepository friendRepository = new FriendRepository();
        return friendRepository.getAllFromUser(userId);
    }
    
    @GetMapping("/debug/friends")
    public List<Friend> getAllFriends() {
        FriendRepository friendRepository = new FriendRepository();
        return friendRepository.getAll();
    }
    
    @PostMapping("/user/{id}/friends")
    public Friend insertFriend(@PathVariable String id, @RequestBody Map<String, String> body) {
        int userId = Integer.parseInt(id);
        FriendRepository friendRepository = new FriendRepository();
        Friend f = new Friend(userId, Integer.parseInt(body.get("friend_id")));
        return friendRepository.insert(f);
    }
    
    @DeleteMapping("/user/{id}/friends")
    public boolean deleteFriend(@PathVariable String id, @RequestBody Map<String, String> body) {
        int userId = Integer.parseInt(id);
        FriendRepository friendRepository = new FriendRepository();
        Friend f = new Friend(userId, Integer.parseInt(body.get("friend_id")));
        return friendRepository.delete(f);
    }
    
}
