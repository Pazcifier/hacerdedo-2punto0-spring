/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repositories;

import com.example.demo.DB.ConnectionFactory;
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
public class UserRepository implements InterfaceRepository<User> {

    /*
    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getOne(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAll(Example exmpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAll(Example exmpl, Sort sort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page findAll(Pageable pgbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object save(Object s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional findById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(Iterable itrbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional findOne(Example exmpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page findAll(Example exmpl, Pageable pgbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count(Example exmpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(Example exmpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
    private User extract(ResultSet rs) throws SQLException {
        User u = new User();
                
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        u.setLast_name(rs.getString("last_name"));
        u.setPhone(rs.getString("phone"));
        u.setRating(rs.getDouble("rating"));
        u.setType(rs.getString("type"));
        u.setPassword(rs.getString("password"));
                
        return u;
    }
    
    @Override
    public User get(int id) {
        Connection con = ConnectionFactory.getConnection();
        String query = String.format("SELECT * FROM users WHERE id = %s", id);
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

    @Override
    public List<User> getAll() {
        Connection con = ConnectionFactory.getConnection();
        String query = "SELECT * FROM users";
        List<User> usuarios = new ArrayList<User>();
        try {
            Statement selectAll = con.createStatement();
            ResultSet rs = selectAll.executeQuery(query);
            
            while (rs.next()) {
                User u = extract(rs);
                usuarios.add(u);
            }
            return usuarios;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            ConnectionFactory.closeConnection(con);
        }
        return null;
    }

    @Override
    public User insert(User u) {
        Connection con = ConnectionFactory.getConnection();
        String query = "INSERT INTO users(id, name, last_name, phone, password) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            if (ps != null) {
                ps.setInt(1, u.getId());
                ps.setString(2, u.getName());
                ps.setString(3, u.getLast_name());
                ps.setString(4, u.getPhone());
                ps.setString(5, u.getPassword());
                
                int i = ps.executeUpdate();
                
                if (i == 1) {
                    return u;
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            ConnectionFactory.closeConnection(con);
        }
        return null;
    }

    @Override
    public User update(User u) {
        Connection con = ConnectionFactory.getConnection();
        String query = String.format("UPDATE users SET name = ?, last_name = ?, phone = ?, password = ? WHERE id = ?");
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, u.getName());
            ps.setString(2, u.getLast_name());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getPassword());
            ps.setInt(5, u.getId());
            
            int i = ps.executeUpdate();
            
            if (i == 1) {
                return u;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        finally {
            ConnectionFactory.closeConnection(con);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Connection con = ConnectionFactory.getConnection();
        String query = String.format("DELETE FROM users WHERE id = %s", id);
        try {
            Statement delete = con.createStatement();
            int i = delete.executeUpdate(query);
            
            if (i == 1) {
                return true;
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
