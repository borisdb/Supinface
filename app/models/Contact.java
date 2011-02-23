package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Contacts")
public class Contact extends Model {
    @ManyToOne
    private User owner;
    @ManyToOne
    private ContactType contactType;
    private String value;
    
    public Contact(User owner, ContactType contactType, String value) {
        super();
        this.owner = owner;
        this.contactType = contactType;
        this.value = value;
    }
    
    
}
