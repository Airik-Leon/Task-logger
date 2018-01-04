package data;

import java.util.List;

import entities.User;

public interface UserDAO {
	public List<User> index(); 
	public User show(int id); 
	public User create(String json); 
	public User update(String json); 
	public User destroy(int id); 
}
