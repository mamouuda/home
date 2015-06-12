/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.upnp;


/**
 *
 * @author mouadh
 */


public class maintest {

    
    public static void main (String args[]){
        System.out.println( "test args" +args[0]);
        UPnP.RegisterPort(5000);
    }
    
}
