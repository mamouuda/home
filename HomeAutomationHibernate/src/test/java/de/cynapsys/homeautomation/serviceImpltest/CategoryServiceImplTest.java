/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpltest;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.serviceImpl.CategoryServiceImpl;
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
public class CategoryServiceImplTest {
    
    public CategoryServiceImplTest() {
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
     * Test of addCategory method, of class CategoryServiceImpl.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        Category c = new Category("category", "Category Description");
        CategoryServiceImpl instance = new CategoryServiceImpl();
        Long result = instance.addCategory(c);
        assertNotNull( result);
    }

    /**
     * Test of getCategoryById method, of class CategoryServiceImpl.
     */
    @Test
    public void testGetCategoryById() {
        System.out.println("getCategoryById");
        Long id = 39L;
        CategoryServiceImpl instance = new CategoryServiceImpl();
        Category result = instance.getCategoryById(id);
        assertNotNull( result);
    }

    /**
     * Test of getAllCategories method, of class CategoryServiceImpl.
     */
    @Test
    public void testGetAllCategories() {
        System.out.println("getAllCategories");
        CategoryServiceImpl instance = new CategoryServiceImpl();
        List<Category> result = instance.getAllCategories();
        assertNotNull(result);
    }

    /**
     * Test of deleteCategory method, of class CategoryServiceImpl.
     */

    
}
