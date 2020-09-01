/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringWebMVCTest1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author lendle
 */
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String subject=null;
    private String task=null;
    private String dueDate=null;
    private boolean completed=false;

    public Todo() {
    }
    
    public Todo(String subject, String task, String dueDate) {
        this.subject=subject;
        this.task=task;
        this.dueDate=dueDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    
}
