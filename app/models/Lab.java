package models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Labs")
public class Lab extends Model {
    public String name;
    @OneToMany(mappedBy="lab")
    public List<User> members;
    @OneToOne
    public User glm;
}
