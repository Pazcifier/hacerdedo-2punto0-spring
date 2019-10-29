/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repositories;

import com.example.demo.DB.ConnectionFactory;
import com.example.demo.Entities.Friend;
import com.example.demo.Entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante.fit
 */
public class FriendRepository implements InterfaceRepository<Friend>{

    private Friend extract(ResultSet rs) throws SQLException {
        Friend f = new Friend();
                
        f.setUser_id(rs.getInt("user_id"));
        f.setFriend_id(rs.getInt("friend_id"));
                
        return f;
    }
    
    @Override
    public Friend get(int id) {
        Connection con = ConnectionFactory.getConnection();
        String query = String.format("SELECT * FROM friends WHERE user_id = %s", id);
        try {
            Statement selectOne = con.createStatement();
            ResultSet rs = selectOne.executeQuery(query);
            
            while(rs.next()) {
                return extract(rs);
            }
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            ConnectionFactory.closeConnection(con);
        }
        return null;
    }
    
    public List<Friend> getAllFromUser(int id) {
        Connection con = ConnectionFactory.getConnection();
        String query = String.format("SELECT * FROM friends WHERE user_id = %s", id);
        List<Friend> friends = new ArrayList<Friend>();
        try {
            Statement selectAll = con.createStatement();
            ResultSet rs = selectAll.executeQuery(query);
            
            while(rs.next()) {
                Friend f = extract(rs);
                friends.add(f);
            }
            return friends;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            ConnectionFactory.closeConnection(con);
        }
        return null;
    }

    @Override
    public List<Friend> getAll() {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT * FROM friends";
        List<Friend> friends = new ArrayList<Friend>();
        try {
            Statement selectAll = con.createStatement();
            ResultSet rs = selectAll.executeQuery(query);
            
            while (rs.next()) {
                Friend v = extract(rs);
                friends.add(v);
            }
            return friends;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            ConnectionFactory.closeConnection(con);
        }
        return null;
    }

    @Override
    public Friend insert(Friend f) {
        if (f.getUser_id() != f.getFriend_id()) {
            Connection con = ConnectionFactory.getConnection();
            String query = "INSERT INTO friends(user_id, friend_id) VALUES (?, ?)";
            try {
                con.setAutoCommit(false);
                PreparedStatement ps = con.prepareStatement(query);
                if (ps != null) {
                    ps.setInt(1, f.getUser_id());
                    ps.setInt(2, f.getFriend_id());

                    int i = ps.executeUpdate();

                    ps.setInt(1, f.getFriend_id());
                    ps.setInt(2, f.getUser_id());

                    int j = ps.executeUpdate();

                    con.setAutoCommit(true);

                    if (i == 1 && j == 1) {
                        return f;
                    }
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            finally {
                ConnectionFactory.closeConnection(con);
            }
        }
        return null;
    }

    @Override
    public Friend update(Friend t) {
        return null;
    }

    //Revisar bien este
    @Override
    public boolean delete(Friend f) {
        Connection con = ConnectionFactory.getConnection();
        String query = "DELETE FROM friends WHERE user_id = ? AND friend_id = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(query);
            if (ps != null) {
                ps.setInt(1, f.getUser_id());
                ps.setInt(2, f.getFriend_id());
                
                int i = ps.executeUpdate();
                
                ps.setInt(1, f.getFriend_id());
                ps.setInt(2, f.getUser_id());
                
                int j = ps.executeUpdate();
                
                con.setAutoCommit(true);
                
                if (i == 1 && j == 1) {
                    return true;
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            ConnectionFactory.closeConnection(con);
        }
        return false;
    }
}
