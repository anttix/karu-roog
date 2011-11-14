package ee.itcollege.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooToString
@RooEntity
public class Bear {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Size(min = 2, max = 25)
	private String name;
	@ManyToOne
	private Cage cage;
	@ManyToOne
	private Menu menu;
	public Cage getCage() {
	    return cage;
	}
	public void setCage(Cage param) {
	    this.cage = param;
	}
	public Menu getMenu() {
	    return menu;
	}
	public void setMenu(Menu param) {
	    this.menu = param;
	}
}
