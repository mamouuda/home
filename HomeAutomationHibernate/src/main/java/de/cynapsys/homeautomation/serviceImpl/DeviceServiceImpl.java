/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Room;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.service.DeviceService;
import de.cynapsys.homeautomation.service.RoomService;
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

public class DeviceServiceImpl implements DeviceService{

    static transient Session session;
    final static Logger logger = Logger.getLogger(DeviceServiceImpl.class);

    @Override
    public Long addDevice(Device d) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Long id=(Long)session.save(d);
        session.getTransaction().commit();
        session.close();
        logger.info("Add new device : ID : "+d.getId()+" device name"+d.getName());
        return id;
    }

    @Override
    public Device getDeviceById(Long id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Device where id = :id ");
        query.setParameter("id", id);
        
        Device dd= (Device)query.uniqueResult();
        session.close();
        logger.info("get device by ID called : ID : "+id);
        return dd;
    }

    @Override
    public List<Device> getAllDevices() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Device> lc=session.createCriteria(Device.class).list();
        session.getTransaction().commit();
        session.close();
        logger.info("get all devices called : ");
        return lc;
    }

    @Override
    public boolean deleteDevice(Long id) {
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(new Device(id, null, null, 0));
            session.getTransaction().commit();
            session.close();
            logger.info("delete device called : ID : " + id);
            return true;
        } catch (HibernateException hibernateException) {
            logger.error("fail delete device called : " + hibernateException);
            return false;
        }
    }

    @Override
    public boolean updateDevice(Device d) {
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(d);
            session.getTransaction().commit();
            session.close();
            logger.info("update device called : ID : "+d.getId()+" device name"+d.getName());
            return true;
        } catch (HibernateException hibernateException) {
            logger.error("fail delete device called : " + hibernateException);
            return false;
        }
    }

    @Override
    public List<Device> getDevicesByRoom(Room r) {
        RoomService rs = new RoomServiceImpl();
        Room rr=rs.getRoomById(r.getId());
        logger.info("Get device by room called : ID room : "+r.getId()+" Room name: "+r.getName());
        return rr.getDevices();
    }

    @Override
    public List<Device> getDevicesByCategory(Category c) {
        CategoryService cs = new CategoryServiceImpl();
        Category cc=cs.getCategoryById(c.getId());
        logger.info("get device by category called : ID category : "+c.getId()+" category name: "+c.getName());
        return cc.getDevices();
    }
    
}
