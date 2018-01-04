package data;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Todo;
import entities.User;

@Repository
@Transactional
public class TodoDAOImpl implements TodoDAO {
	@PersistenceContext
	EntityManager em; 
	
	public List<Todo> index(){
		String query = "SELECT t FROM Todo t"; 
		return em.createQuery(query, Todo.class).getResultList(); 
	}
	public Todo show(int id) {
		return em.find(Todo.class, id); 
	}
	public Todo create(String json) {
		ObjectMapper mapper = new ObjectMapper(); 
		Todo todo = null; 
		try {
			todo = mapper.readValue(json, Todo.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return todo;
	}
	public Todo update(String json) {
		ObjectMapper mapper = new ObjectMapper(); 
		Todo todo = null; 
		Todo retTodo = null; 
		
		try {
			todo = mapper.readValue(json, Todo.class);
			retTodo = em.find(Todo.class,todo.getId());
			retTodo.setCompleted(todo.isCompleted());
			retTodo.setCompletedDate(todo.getCompletedDate());
			retTodo.setCreateAt(todo.getCreateAt());
			retTodo.setDueDate((todo.getDueDate())); 
			retTodo.setDescription(todo.getDescription());
			retTodo.setLastUpdate(todo.getLastUpdate());
			retTodo.setTask(todo.getTask());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retTodo;
	}
	public Todo destroy(int id) {
		Todo todo = em.find(Todo.class, id); 
		em.remove(todo);
		return todo; 
	}
}
