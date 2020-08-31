/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringWebMVCTest1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lendle
 */
public class TodoData {
    public static List<Todo> todoList=new ArrayList<>();
    static{
        todoList.add(new Todo("Lab Tutorial 1", "完成 Lab Tutorial 1", "2020-08-02"));
        todoList.add(new Todo("Lab Tutorial 2", "完成 Lab Tutorial 2", "2020-08-03"));
    }
    
    public static Todo getTodo(String id){
        for(Todo todo : todoList){
            if(id.equals(todo.getId())){
                return todo;
            }
        }
        return null;
    }
    
    public static void removeTodo(String id){
        Todo todo=getTodo(id);
        todoList.remove(todo);
    }
}
