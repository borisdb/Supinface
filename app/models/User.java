package models;

import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;


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
    @NoRender
    public String password;
    public String pictureUrl;
    public int promo;
    public String otherInfos;


    @ManyToOne
    @JoinColumn
    public Lab lab;
  
    @ManyToOne
    @JoinColumn
    public Campus campus;

    @OneToMany(mappedBy = "owner",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    public List<Contact> contacts;
    
    @OneToMany(mappedBy = "owner",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    public List<Skill> skills;
    @OneToMany(mappedBy = "owner",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    public List<Group> ownedGroups;
    @ManyToMany(mappedBy="members")
    public List<Group> insideGroups;


    
    
    
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
	
	public User(String idBooster, String lastName, String firstName, String email,
        String password, String pictureUrl, int promo, String otherInfos,
        Campus campus) {
    super();
    this.idBooster = idBooster;
    this.lastName = lastName;
    this.firstName = firstName;
    this.email = email;
    this.password = password;
    this.pictureUrl = pictureUrl;
    this.promo = promo;
    this.otherInfos = otherInfos;
    this.campus = campus;
}

    @Override
	public String toString() {
		return idBooster+" : "+firstName+" : "+lastName+" : "+email+" : "+password+" : "+pictureUrl+" : "+promo+" : "+otherInfos+" : "+campus.name;
	}
		
}

