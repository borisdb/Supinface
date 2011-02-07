package models;

import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.jpa.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name="Users")
public class User extends Model {

	public String idBooster;
    public String lastName;
    public String firstName;
    public String email;
    public String password;
    public String pictureUrl;
    public int promo;
    public String other_infos;

    @ManyToOne
    public Lab lab;
    @ManyToOne
    public Campus campus;

    @OneToMany(mappedBy = "owner",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    public List<Contact> contacts;
    @OneToMany(mappedBy = "owner",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    public List<Skill> skills;
    @OneToMany(mappedBy = "owner",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    public List<Group> owned_groups;
    @ManyToMany(mappedBy="members")
    public List<Group> inside_groups;
    
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

