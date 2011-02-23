package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Contacts")
public class Contact extends Model {

    @NoRender
    @ManyToOne
    @JoinColumn
    public User owner;
    @ManyToOne
    @JoinColumn
    public ContactType contactType;
    public String value;
    
    public Contact(User owner, ContactType contactType, String value) {
        super();
        this.owner = owner;
        this.contactType = contactType;
        this.value = value;
    }
}
