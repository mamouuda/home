/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.entity.Room;
import de.cynapsys.homeautomation.service.RoomService;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author mouadh
 */

public class RoomServiceImpl implements RoomService{

    static transient Session session;
    final static Logger logger = Logger.getLogger(RoomServiceImpl.class);
    
    @Override
    public Long addRoom(Room r) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long id=(Long)session.save(r);
        session.getTransaction().commit();
        session.close();
        logger.info("Add new room : ID : "+r.getId()+" Room name"+r.getName());
        return id;
   }

    @Override
    public Room getRoomById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Room where id = :id ");
        query.setParameter("id", id);
        
        Room rr= (Room)query.uniqueResult();
        session.close();
        logger.info("get room by ID called : ID : "+id);
        return rr;
    }

    @Override
    public List<Room> getAllRooms() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Room> lr = session.createCriteria(Room.class).list();
        session.getTransaction().commit();
        session.close();
        logger.info("get all rooms called : ");
        return removeDuplicates(lr);
    }
    
    private List<Room> removeDuplicates(List<Room> list) {
        List<Room> res = new ArrayList<>();
         for (Room r : list){
             if ( !res.contains(r)){
                 res.add(r);
             }
         }
         return res;
    }

    @Override
    public boolean deleteRoom(Long id) { 
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(new Room(id, null, null));
            session.getTransaction().commit();
            session.close();
            logger.info("delete room called : ID : " + id);
            return true;
        } catch (HibernateException hibernateException) {
            logger.error("fail delete room called : " + hibernateException);
            return false;
        }
    }

    @Override
    public boolean updateRoom(Room r) {
            try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(r);
            session.getTransaction().commit();
            session.close();
            logger.info("update room called : ID : "+r.getId()+" Room name"+r.getName());
            return true;
        } catch (HibernateException hibernateException) {
            logger.error("fail room category called : " + hibernateException);
            return false;
        }
    }  
}
