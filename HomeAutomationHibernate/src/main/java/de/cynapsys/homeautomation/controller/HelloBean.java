/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.controller;

/**
 *
 * @author mouadh
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ApplicationScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}