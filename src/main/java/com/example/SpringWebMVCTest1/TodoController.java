/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringWebMVCTest1;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lendle
 */
@Controller
public class TodoController {
    @PersistenceContext
    private EntityManager entityManager;
    
    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("todoList", 
                entityManager.createQuery("select o from Todo o").getResultList());
        return "index";
    }
    
    @GetMapping("/addTodo")
    public String addTodo(Model model){
        model.addAttribute("todo", new Todo("", "", ""));
        return "addTodo";
    }
    
    @Transactional
    @PostMapping("/addTodo")
    public ModelAndView addTodo(Todo todo){
        entityManager.persist(todo);
        return new ModelAndView("redirect:/", "todoList", TodoData.todoList);
    }
    
    @GetMapping("/editTodo/{id}")
    public String editTodo(Model model, @PathVariable("id") long id){
        Todo todo=entityManager.find(Todo.class, id);
        model.addAttribute("todo", todo);
        return "/editTodo";
    }
    
    @Transactional
    @PostMapping("/editTodo")
    public ModelAndView editTodo(Todo todo){
        entityManager.merge(todo);
        return new ModelAndView("redirect:/", "todoList", TodoData.todoList);
    }
    
    @GetMapping("/removeTodo/{id}")
    @Transactional
    public ModelAndView removeTodo(@PathVariable("id") long id){
        Query query=entityManager.createQuery("delete from Todo o where o.id=:id");
        query.setParameter("id", id).executeUpdate();
        return new ModelAndView("redirect:/", "todoList", 
                entityManager.createQuery("select o from Todo o").getResultList());
    }
}
