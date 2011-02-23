package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Contact_Types")
public class ContactType extends Model {
    public String name;
    public String urlPicture;
    @NoRender
    @OneToMany(mappedBy = "contactType",cascade=CascadeType.ALL)
    public List<Contact> contacts;
}
