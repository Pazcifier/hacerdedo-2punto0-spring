/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repositories;

import com.example.demo.Entities.User;
import java.sql.ResultSet;
import java.util.List;

public interface InterfaceRepository<T> {
    T get(int id);
    List<T> getAll();
    T insert(T t);
    T update(T t);
    boolean delete(T t);
}
