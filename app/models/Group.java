package models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Groups")
public class Group extends Model {
    @NoRender
    @ManyToOne
    @JoinColumn
    public User owner;
    public String name;
    @NoRender
    @ManyToMany
    @JoinTable
    public List<User> members;
}
