package com.example;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import com.example.UpdateTodo;

@UIScope
@SpringComponent
class TodoList extends VerticalLayout implements TodoChangeListener {
    @Autowired
    TodoRepository repository;
    public List<Todo> todos;
    UpdateTodo update;
    
    public TodoList(UpdateTodo updateTodo) {
    	if(updateTodo == null) {
    		update = new UpdateTodo();
    	} else {
    		update = updateTodo;
    	}
    }

    @PostConstruct
    public void init() {
        setWidth("80%");

        update();
    }

    public void update() {
        setTodos(repository.findAll());
    }

    private void setTodos(List<Todo> todos) {
        this.todos = todos;
        removeAllComponents();
        todos.forEach(todo -> addComponent(new TodoLayout(todo, this)));
    }

    public void addTodo(Todo todo) {
    	update.set(todo);
        
    	repository.save(todo);
        update();
    }

    @Override
    public void todoChanged(Todo todo) {
        addTodo(todo);
    }


    public void deleteCompleted() {
        repository.deleteByDone(true);
        update();
    }
}
