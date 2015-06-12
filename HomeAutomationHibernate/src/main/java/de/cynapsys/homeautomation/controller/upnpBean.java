/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.controller;
import de.cynapsys.homeautomation.entity.network.UpnpEntity;
import de.cynapsys.homeautomation.service.network.UpnpService;
import de.cynapsys.homeautomation.serviceImpl.network.UpnpServiceImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import utils.Utils;

/**
 *
 * @author mouadh
 */
@ManagedBean
@SessionScoped
public class upnpBean {

    static transient Session session;
    private List<UpnpEntity> values;

    private final UpnpService upnpService = new UpnpServiceImpl();
    private UpnpEntity upnp;

    @PostConstruct
    public void init() {
        values = upnpService.getAllPorts();
        upnp = new UpnpEntity();
    }

    public void submit(int port) {

        if (upnpService.getUpnpByPort(port) == null) {

            upnp = new UpnpEntity(port);
            upnpService.addPort(upnp);
        }
        try {
            StringBuilder path =new StringBuilder();
            Utils.createBat(port,"upnp",path);
            System.out.println(path);
            String cmd="cmd /c start "+path; 
            Runtime r=Runtime.getRuntime(); 
            Process pr=r.exec(cmd); 
            //upnpService.addPort(port);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "port enregistrer avec succés"));
        }

    }
    
    public boolean test(String status){
        return "Opened".equals(status);
    }

    public String portStatus(int port) {
        return upnpService.getPortStatus(port);
    }

    public void extend() {
        values.add(new UpnpEntity());
    }

    public void setValues(List<UpnpEntity> values) {
        this.values = values;
    }

    public List<UpnpEntity> getValues() {
        return values;
    }

    public UpnpEntity getUpnp() {
        return upnp;
    }

    public void setUpnp(UpnpEntity upnp) {
        this.upnp = upnp;
    }

}
