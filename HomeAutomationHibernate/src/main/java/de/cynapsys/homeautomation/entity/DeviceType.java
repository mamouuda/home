/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author mouadh
 */
@Entity
public class DeviceType {
    
    private String type;

    public DeviceType() {
    }

    public DeviceType( String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public static List<String> getAllTypes(){
        ArrayList<String> typesList = new ArrayList<>();
        typesList.add("ON_OFF_DEVICE");
        typesList.add("VALUE_DEVICE");
        return typesList;
    }
    
}
