package models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

import play.db.jpa.Model;

@Entity
@Table(name="Campuses")
public class Campus extends Model {
    
    public String name;
    @JsonManagedReference("campus-members")
    @OneToMany(mappedBy = "campus")
    public Collection<User> members;
    
    public Campus()
    {
    }

    
    
}
