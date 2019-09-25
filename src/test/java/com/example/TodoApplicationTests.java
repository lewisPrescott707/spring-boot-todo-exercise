package com.example;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;

import org.h2.command.dml.Update;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoApplicationTests {

	@Test
	public void contextLoads() {
	}

	public TodoList todoList;
	Todo todo = new Todo();
	TodoRepository todoRepo = Mockito.mock(TodoRepository.class);
	
	@Mock
	UpdateTodo update = Mockito.mock(UpdateTodo.class);
	
	@Before
	public void Setup() {
		MockitoAnnotations.initMocks(this);

		todo.setText("test");
		List<Todo> list = new ArrayList<Todo>() { {new Todo().setText("text");} };
		todoList = new TodoList(update);
		ReflectionTestUtils.setField(todoList, "repository", todoRepo);
		Mockito.doReturn(list).when(todoRepo).findAll();
		todoList.init();
	}
	
	
	@Test
	public void todoIsChecked() {
		todoList.addTodo(todo);
		
		Mockito.verify(update, Mockito.times(1)).set(Mockito.any(Todo.class));
	}

}
