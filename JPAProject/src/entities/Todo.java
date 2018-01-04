package entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private String task; 
	private String description; 
	private boolean completed; 
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user; 
	@Column(name="due_date")
	private String dueDate; 
	@Column(name="complete_date")
	private String completedDate; 
	@Column(name="created_at")
	private LocalDateTime createAt; 
	@Column(name="updated_at")
	private LocalDateTime lastUpdate;
	
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", task=" + task + ", description=" + description + ", completed=" + completed
				+ ", user=" + user + ", dueDate=" + dueDate + ", completedDate=" + completedDate + ", createAt="
				+ createAt + ", lastUpdate=" + lastUpdate + "]";
	}
}
