/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.webserviceImpl;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.Room;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.service.DeviceService;
import de.cynapsys.homeautomation.service.RoomService;
import de.cynapsys.homeautomation.serviceImpl.CategoryServiceImpl;
import de.cynapsys.homeautomation.serviceImpl.DeviceServiceImpl;
import de.cynapsys.homeautomation.serviceImpl.RoomServiceImpl;
import de.cynapsys.homeautomation.webservice.DeviceWebService;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
/**
 *
 * @author mouadh
 */
@WebService(endpointInterface = "de.cynapsys.homeautomation.webservice.DeviceWebService")
public class DeviceWebServiceImpl implements DeviceWebService{

    
//        ClassPathXmlApplicationContext cpx; 
//        DeviceService deviceService; 
//        
//        
    DeviceService deviceService = new DeviceServiceImpl();
    RoomService roomService = new RoomServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
//        
//        
//    public DeviceWebServiceImpl() {
//        
//        cpx = new ClassPathXmlApplicationContext("classpath:config/spring-config.xml");
//        deviceService = cpx.getBean(DeviceService.class);
//        
//    }

    @Override
    public Device[] getAllDevices() {
        Device[] list = {};
        List<Device> l= deviceService.getAllDevices();
        list = new Device[l.size()];
        for (int i=0;i<l.size();i++){
            Device d = l.get(i);
            d.setCategory(null);
            d.setRoom(null);
            list[i]=d;
        }
        return list;
    }

    @Override
    public Device getDeviceByID(Long deviceID) {
        Device d = (Device) deviceService.getDeviceById(deviceID);
        d.setCategory(null);
        d.setRoom(null);
        return d;
    }

    @Override
    public int getValue(Long deviceID) {
        Device device = getDeviceByID(deviceID);
        return device.getCurrentValue();
    }

    @Override
    public boolean setValue(Long deviceID, int value) {
        try{
            Device device = getDeviceByID(deviceID);
            device.setCurrentValue(value);
            deviceService.updateDevice(device);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public Long addDevice(Device device) {
        return deviceService.addDevice(device);
    }

    @Override
    public boolean deleteDevice(Long deviceID) {

           return deviceService.deleteDevice(deviceID);

    }

    @Override
    public boolean updateDevice(Device device) {

         return   deviceService.updateDevice(device);

    }

    @Override
    public Device[] getDevicesByRoom(Long roomID) {
        Device[] list = {};
        Room r = roomService.getRoomById(roomID);
        List<Device> l= deviceService.getDevicesByRoom(r);
        list = new Device[l.size()];
        for (int i=0;i<l.size();i++){
            Device d = l.get(i);
            d.setCategory(null);
            d.setRoom(null);
            list[i]=d;
        }
        return list;
    }

    @Override
    public Device[] getDevicesByCategory(Long categoryID) {
        Device[] list = {};
        Category c = categoryService.getCategoryById(categoryID);
        List<Device> l= deviceService.getDevicesByCategory(c);
        list = new Device[l.size()];
        for (int i=0;i<l.size();i++){
            Device d = l.get(i);
            d.setCategory(null);
            d.setRoom(null);
            list[i]=d;
        }
        return list;
    }
    
}
