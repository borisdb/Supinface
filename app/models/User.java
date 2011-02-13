package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class User extends Model {

	public String idBooster;
	public String password;
	public String firstName;
	public String lastName;
	public String email;

    @ManyToOne
	public Campus campus; 
	
	
	public User(String idBooster, String password, String firstName,
			String lastName, String email) {
		this.idBooster = idBooster;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}




	public static User connect(String login,String password)
	{
		User user=User.find("byIdBoosterAndPassword",login,password).first();
		
		if(user==null)
		{
			//Verifier nom.prénom
			
			Pattern p = Pattern.compile("\\.");
			String[] nomprenom=p.split(login);
			if(nomprenom.length==2)
			{
				user=User.find("byFirstNameAndLastNameAndPassword",nomprenom[0],nomprenom[1],password).first();
			}
		}
		if(user==null)
		{
			// verifier email
			
			Pattern pattern = Pattern.compile("@");
			Matcher matcher=pattern.matcher(login);
			
			int i =0;
			while(matcher.find())
			{
				i+=1;
			}
			if(i==1)
			{
				user=User.find("byEmailAndPassword",login,password).first();
			}
		}
		return user;
	}
	
	@Override
	public String toString() {
		return idBooster+" : "+firstName+" : "+lastName;
	}
		
}
