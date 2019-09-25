package com.example;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@UIScope
@SpringComponent
public class UpdateTodo {

	public void set(Todo todo) {
    	todo.setDone(true);
    	System.out.println("Todo is ticked: " + todo.isDone());
    }
}
