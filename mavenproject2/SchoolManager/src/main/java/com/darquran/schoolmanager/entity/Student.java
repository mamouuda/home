/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darquran.schoolmanager.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mouadh
 */
@Entity
public class Student {
    
    private int idStudent;
    private String firstNameStudent;
    private String lastnameStudent;
    private Date birthDayStudent;
    private String levelStudent;
    private String emailStudent;
    private String phoneStudent;
    private String adrStudent;

    public Student() {
    }

    public Student(String firstNameStudent, String lastnameStudent, Date birthDayStudent, String levelStudent, String emailStudent, String phoneStudent, String adrStudent) {
        this.firstNameStudent = firstNameStudent;
        this.lastnameStudent = lastnameStudent;
        this.birthDayStudent = birthDayStudent;
        this.levelStudent = levelStudent;
        this.emailStudent = emailStudent;
        this.phoneStudent = phoneStudent;
        this.adrStudent = adrStudent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstNameStudent() {
        return firstNameStudent;
    }

    public void setFirstNameStudent(String firstNameStudent) {
        this.firstNameStudent = firstNameStudent;
    }

    public String getLastnameStudent() {
        return lastnameStudent;
    }

    public void setLastnameStudent(String lastnameStudent) {
        this.lastnameStudent = lastnameStudent;
    }

    public Date getBirthDayStudent() {
        return birthDayStudent;
    }

    public void setBirthDayStudent(Date birthDayStudent) {
        this.birthDayStudent = birthDayStudent;
    }

    public String getLevelStudent() {
        return levelStudent;
    }

    public void setLevelStudent(String levelStudent) {
        this.levelStudent = levelStudent;
    }

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    public String getPhoneStudent() {
        return phoneStudent;
    }

    public void setPhoneStudent(String phoneStudent) {
        this.phoneStudent = phoneStudent;
    }

    public String getAdrStudent() {
        return adrStudent;
    }

    public void setAdrStudent(String adrStudent) {
        this.adrStudent = adrStudent;
    }
    
    
}
