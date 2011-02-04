package models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Campuses")
public class Campus extends Model {
    
    public String name;
    @OneToMany(mappedBy = "campus")
    public List<User> members;
}
