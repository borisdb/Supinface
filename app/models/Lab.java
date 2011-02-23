package models;

import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Labs")
public class Lab extends Model {
    public String name;
    @NoRender
    @OneToMany(mappedBy="lab")
    public List<User> members;
    @NoRender
    @OneToOne
    @JoinColumn
    public User glm;
    
    public Lab(String name, User glm) {
        super();
        this.name = name;
        this.glm = glm;
    }

    public Lab(String name, List<User> members, User glm) {
        super();
        this.name = name;
        this.members = members;
        this.glm = glm;
    }
    
    
    
    
    
}
