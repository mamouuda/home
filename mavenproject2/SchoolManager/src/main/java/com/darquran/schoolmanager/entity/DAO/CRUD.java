/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darquran.schoolmanager.entity.DAO;

import java.util.List;

/**
 *
 * @author mouadh
 * @param <Class>
 * @param <ID>
 */
public interface CRUD <Class,ID>{
    public int add(Class c);
    public Class findById(Class c,ID id);
    public List<Class> findAll(Class c);
    public void delete(ID id);
    public void update(Class c);
}
