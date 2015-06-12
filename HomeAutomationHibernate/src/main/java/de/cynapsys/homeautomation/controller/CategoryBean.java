/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.controller;

import de.cynapsys.homeautomation.entity.Category;
import de.cynapsys.homeautomation.service.CategoryService;
import de.cynapsys.homeautomation.serviceImpl.CategoryServiceImpl;
import java.io.Serializable;
import java.util.List;
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
public class CategoryBean implements Serializable {

    List<Category> categoryList;
    Category category;
    Category cat;
    Category categoryForDevices;
    CategoryService categoryService = new CategoryServiceImpl();
    String id;
    

    @PostConstruct
    public void init() {
        categoryList = categoryService.getAllCategories();
        category = new Category();
        cat = new Category();
        categoryForDevices = new Category();
        System.out.println(categoryList);
    }

    public void addCategory() {
        try {
            System.out.println("test add category");
            categoryService.addCategory(cat);
            categoryList = categoryService.getAllCategories();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "Catégorie ajoutée avec succés")); 
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "erreur dans l'ajout"+e.toString()));
        }
    }

    public void deleteCategory(Category c) {
        try {
            System.out.println(" i am a function delete category");
            System.out.println(c);
            categoryService.deleteCategory(c.getId());
            categoryList = categoryService.getAllCategories();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "Catégorie supprimée avec succés"));
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "erreur dans la supprission"+e.toString()));
        }

    }

    public void updateCategory() {
        try {
            System.out.println("i am update category" + category);
            categoryService.updateCategory(category);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "Catégorie modifiée avec succés"));
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "erreur dans la modification"+e.toString()));
        }
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public Category getCategoryForDevices() {
        return categoryForDevices;
    }

    public void setCategoryForDevices(Category categoryForDevices) {
        this.categoryForDevices = categoryForDevices;
    }
    
    
    

}
