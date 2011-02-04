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
    private Contact_Type contact_type;
    private String value;
}
