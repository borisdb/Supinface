package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class User extends Model {

	public int idBooster;
	public String firstName;
	public String lastName;
	public String email;
	
	public User(int idBooster, String firstName, String lastName, String email) {
		this.idBooster = idBooster;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
		
}
