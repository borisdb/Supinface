package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import play.db.jpa.Model;

@Entity
@Table(name="Skills")
public class Skill extends Model {
    @ManyToOne
    public User owner;
    public String label;
    public int rate;
}
