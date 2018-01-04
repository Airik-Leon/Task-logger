package data;

import java.util.List;

import entities.Todo;

public interface TodoDAO {
	public List<Todo> index(); 
	public Todo show(int id); 
	public Todo create(String json); 
	public Todo update(String json); 
	public Todo destroy(int id); 
	
}
