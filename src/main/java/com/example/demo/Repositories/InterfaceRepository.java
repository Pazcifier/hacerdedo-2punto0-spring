/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repositories;

import com.example.demo.Entities.User;
import java.util.List;
import org.springframework.data.repository.query.Param;

public interface InterfaceRepository<T> {
    T get(int id);
    List<T> getAll();
    User insert(T t);
    User update(T t);
    boolean delete(int id);
}
