/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darquran.schoolmanager.entity.DAO.test;

import com.darquran.schoolmanager.entity.DAO.CRUD;
import com.darquran.schoolmanager.entity.DAO.Impl.CRUDImpl;
import com.darquran.schoolmanager.entity.Student;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mouadh
 */
public class CRUDImplTest {
    
    public CRUDImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class CRUDImpl.
     */
    @Test
    public void testAdd() {
        CRUD<Student,Integer> crud = new CRUDImpl();
        Student student= new Student("ahmed", "allani", null, null, "lfdkgmdfg@gmail.com", "25 222 333", "Trik hafouz");
        //crud.add(student);
        crud.findById(new Student(),12);
    }

}
