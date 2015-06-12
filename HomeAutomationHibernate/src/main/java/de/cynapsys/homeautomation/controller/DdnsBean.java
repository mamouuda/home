/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.controller;

import de.cynapsys.homeautomation.entity.network.DdnsEntity;
import de.cynapsys.homeautomation.service.network.DDNSService;
import de.cynapsys.homeautomation.serviceImpl.network.DDNSServiceImpl;
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
public class DdnsBean {
    
    private DdnsEntity ddns;
    private final DDNSService ddnsService = new DDNSServiceImpl();

    @PostConstruct
    public void init(){
        ddns= ddnsService.getConfiguration();
        if (ddns==null) ddns=new DdnsEntity();
    }
    
    public void connexion (){
        //ddnsService.submitHostname(ddns);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Connexion établit avec succés") );
    }
    
    public void setConfiguration(){
        ddns.setId(1);
        try {
            ddnsService.changeConfiguration(ddns);
        } catch (Exception e) {
            ddnsService.saveConfiguration(ddns);
        }
        finally{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful",  "Le serveur DDNS est configuré avec succés") );
        }
    }
    
    public DdnsEntity getDdns() {
        return ddns;
    }

    public void setDdns(DdnsEntity ddns) {
        this.ddns = ddns;
    }
    
    
    
}
