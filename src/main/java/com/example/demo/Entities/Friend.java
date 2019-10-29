/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Entities;

import com.example.demo.Entities.Friend.FriendId;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author estudiante.fit
 */

@Entity 
@IdClass(FriendId.class)
@Table(name="friends")
public class Friend {
    
    @Id
    private int user_id;
    @Id
    private int friend_id;
    
    public class FriendId implements Serializable {
        private int user_id;
        private int friend_id;
        
        public FriendId(int user_id, int friend_id) {
            this.user_id = user_id;
            this.friend_id = friend_id;
        }
        
        public FriendId() {}
        
        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FriendId)) return false;
        return Objects.equals(user_id, user_id) &&
                Objects.equals(friend_id, friend_id);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(user_id, friend_id);
        }
    }
    
    public Friend (int user_id, int friend_id) {
        this.user_id = user_id;
        this.friend_id = friend_id;
    }
    
    public Friend() {}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }
    
    
    
}
