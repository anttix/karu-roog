package ee.itcollege.example.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: Menu
 *
 */
@Entity
@RooToString
@RooEntity
public class Menu implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "menu")
	private Collection<Bear> bears;
	@OneToMany(mappedBy = "menu")
	private Collection<Ingredient> ingredients;

	public Menu() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Collection<Bear> getBears() {
	    return bears;
	}
	public void setBears(Collection<Bear> param) {
	    this.bears = param;
	}
	public Collection<Ingredient> getIngredients() {
	    return ingredients;
	}
	public void setIngredients(Collection<Ingredient> param) {
	    this.ingredients = param;
	}
   
}
