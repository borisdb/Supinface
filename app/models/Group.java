package models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Groups")
public class Group extends Model {
    @ManyToOne
    public User owner;
    public String name;
    @ManyToMany
    public List<User> members;
}
