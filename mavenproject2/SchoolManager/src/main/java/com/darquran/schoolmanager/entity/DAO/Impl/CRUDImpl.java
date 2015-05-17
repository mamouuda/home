/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darquran.schoolmanager.entity.DAO.Impl;

import com.darquran.schoolmanager.entity.DAO.CRUD;
import java.util.List;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author mouadh
 * @param <klass>
 * @param <ID>
 */
public class CRUDImpl<klass,ID> implements CRUD<Object, Object>{
    
    static transient Session session;
    klass k ;
    
    @Override
    public int add(Object c) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (int) session.save(c);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    public Object findById(Object c,Object id) {
        System.out.println("Test "+c.getClass());
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> findAll(Object c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
