package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Contact_Types")
public class Contact_Type extends Model {
    public String name;
    public String urlPicture;
    @OneToMany(mappedBy = "contact_type",cascade=CascadeType.ALL)
    public List<Contact> contacts;
}
