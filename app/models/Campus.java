/**
 * 
 */
package models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonManagedReference;

import play.db.jpa.Model;

/**
 * @author boris
 *
 */
@Entity
public class Campus extends Model {

	public String name;

    @NoRender
	@OneToMany(mappedBy="campus")
	public Collection<User> members;

    public Campus(String name)
    { 
        super();
        this.name = name; 
    }
    
    public Campus(String name, Collection<User> members) {
        super();
        this.name = name;
        this.members = members;
    }
    
    
}

