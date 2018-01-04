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

import entities.User;
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	EntityManager em; 
	
	@Override
	public List<User> index() {
		String query = "SELECT u FROM User u"; 
		return em.createQuery(query, User.class).getResultList(); 
	}

	@Override
	public User show(int id) {
		return em.find(User.class, id);
	}

	@Override
	public User create(String json) {
		ObjectMapper mapper = new ObjectMapper(); 
		User user = null; 
		try {
			user = mapper.readValue(json, User.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return user;
	}

	@Override
	public User update(String json) {
		ObjectMapper mapper = new ObjectMapper(); 
		User user = null; 
		User retUser = null; 
		
		try {
			user = mapper.readValue(json, User.class);
			retUser = em.find(User.class, user.getId());
			retUser.setEmail(user.getEmail());
			retUser.setPassword(user.getPassword());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retUser;
	}

	@Override
	public User destroy(int id) {
		User user = em.find(User.class, id); 
		em.remove(user);
		return user;
	}

}
