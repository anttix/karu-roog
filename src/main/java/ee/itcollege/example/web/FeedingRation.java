package ee.itcollege.example.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;

import ee.itcollege.example.entities.Cage;

@Configurable
@RooJavaBean
public class FeedingRation {
	@PersistenceContext
	EntityManager entityManager;
	
	public FeedingRation() {
		
	}
	public FeedingRation(Cage cage, List<String []> items) {
		this.cage = cage;
		this.items = items;
	}
	
	Cage cage;
	List<String []> items;
	
    @SuppressWarnings("unchecked")
	public static FeedingRation findRationsForCage(Cage c) {
    	Query q = entityManager().createQuery(
    	    "SELECT i.name, SUM(i.amount) " +
    	    "  FROM Bear AS b JOIN b.menu AS m JOIN m.ingredients AS i" +
    	    "  WHERE b.cage = :cage" +
    	    "  GROUP BY i.name");
        q.setParameter("cage", c);
        return new FeedingRation(c, q.getResultList());
    }
    
    public static final EntityManager entityManager() {
        EntityManager em = new FeedingRation().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected");
        return em;
    }
}