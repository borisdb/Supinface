package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Hobbies")
public class Hobby extends Model {
    public String name;
    @ManyToOne
    public User owner;
}
