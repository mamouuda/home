/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.controller;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.entity.Device;
import de.cynapsys.homeautomation.entity.DeviceType;
import de.cynapsys.homeautomation.entity.Room;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.service.DeviceService;
import de.cynapsys.homeautomation.service.RoomService;
import de.cynapsys.homeautomation.serviceImpl.CategoryServiceImpl;
import de.cynapsys.homeautomation.serviceImpl.DeviceServiceImpl;
import de.cynapsys.homeautomation.serviceImpl.RoomServiceImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mouadh
 */
@ManagedBean
@SessionScoped
public class DeviceBean {
    
    List<Device> deviceList;
    Device device;
    Device deviceForUpdate;
    
    Room room;
    Category category;
    
    List<String> typesList;
    List<Room> roomList;
    List<Category> catgeoryList;
    
    DeviceService deviceService = new DeviceServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    RoomService roomService = new RoomServiceImpl();
    
    
    
    @PostConstruct
    public void init(){
        deviceList=deviceService.getAllDevices();
        room = new Room();
        category = new Category();
        device= new Device();
        deviceForUpdate = new Device();
        roomList= roomService.getAllRooms();
        catgeoryList=categoryService.getAllCategories();
        typesList=DeviceType.getAllTypes();
    }
    
    public void addDevice(){
        try {
            System.out.println("i am add device method");
            deviceService.addDevice(device);
            deviceList = deviceService.getAllDevices();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "périphérique ajouté avec succés"));
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "erreur dans l'ajout"+e.toString()));
        }
    }
    
    public void updateDevice(){
        try {
            deviceService.updateDevice(deviceForUpdate);
            deviceList = deviceService.getAllDevices();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "périphérique modifié avec succés"));
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "erreur dans la modification"+e.toString()));
        }
    }
    
    public void deleteDevice(Device d) {
        try {
            System.out.println(" i am a function delete category");
            System.out.println(d);
            deviceService.deleteDevice(d.getId());
            deviceList = deviceService.getAllDevices();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "périphérique supprimé avec succés"));
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "erreur dans la supprission"+e.toString()));
        }

    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Device getDeviceForUpdate() {
        return deviceForUpdate;
    }

    public void setDeviceForUpdate(Device deviceForUpdate) {
        this.deviceForUpdate = deviceForUpdate;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Category> getCatgeoryList() {
        return catgeoryList;
    }

    public void setCatgeoryList(List<Category> catgeoryList) {
        this.catgeoryList = catgeoryList;
    }

    public List<String> getTypesList() {
        return typesList;
    }

    public void setTypesList(List<String> typesList) {
        this.typesList = typesList;
    }
    
    
    
    
}
