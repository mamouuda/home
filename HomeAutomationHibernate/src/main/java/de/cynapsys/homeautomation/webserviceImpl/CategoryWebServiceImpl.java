/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.webserviceImpl;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.serviceImpl.CategoryServiceImpl;
import de.cynapsys.homeautomation.webservice.CategoryWebService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebService;

/**
 *
 * @author mouadh
 */
@WebService(endpointInterface = "de.cynapsys.homeautomation.webservice.CategoryWebService")
public class CategoryWebServiceImpl implements CategoryWebService {

    
        
    CategoryService categoryService = new CategoryServiceImpl();

        

    @Override
     public Category[] getAllCategories() {
        Category[] list = {};
        List<Category> l= categoryService.getAllCategories();
        list = new Category[l.size()];
        for (int i=0;i<l.size();i++){
            Category c = l.get(i);
            c.setDevices(null);
            list[i]=c;
        }
        return list;
    }

    @Override
    public Category getCategoryByID(Long CategoryID) {
        Category c= categoryService.getCategoryById(CategoryID);
        c.setDevices(null);
        return c;
    }

    @Override
    public Long addCategory(Category category) {
        return categoryService.addCategory(category);
    }

    @Override
    public boolean deleteCategory(Long CategoryID) {
            return categoryService.deleteCategory(CategoryID);
    }

    @Override
    public boolean updateCategory(Category category) {


            return categoryService.updateCategory(category);

    }

}
