package ee.itcollege.example.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

/**
 * Entity implementation class for Entity: Cage
 *
 */
@Entity
@RooToString
@RooEntity
public class Cage implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min = 1, max = 10)
	private String name;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "cage")
	private Collection<Bear> bears;

	public Cage() {
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
		manageRelations(this.bears, param);
		this.bears = param;
	}

	private void manageRelations(Collection<Bear> oldBears, Collection<Bear> newBears) {
		if(oldBears != null) {
			for(Bear b: oldBears)
				if(newBears == null || !newBears.contains(b))
					b.setCage(null);
		}

		if(newBears != null) {
			for(Bear b: newBears)
				b.setCage(this);
		}
	}

    @Transactional
    public Cage merge() {
        if (this.entityManager == null) this.entityManager = entityManager();

	if(this.id != null && !entityManager.contains(this)) {
		// This was a detached entity, manage bears correctly
		Cage oldCage = Cage.findCage(this.id);
		manageRelations(oldCage.getBears(), this.bears);
        }

        Cage merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
}
