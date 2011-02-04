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
	
}
