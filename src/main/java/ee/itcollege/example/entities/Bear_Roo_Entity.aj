// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.example.entities;

import ee.itcollege.example.entities.Bear;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Bear_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Bear.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer Bear.version;
    
    public Integer Bear.getVersion() {
        return this.version;
    }
    
    public void Bear.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Bear.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Bear.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Bear attached = Bear.findBear(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Bear.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Bear.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Bear Bear.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Bear merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Bear.entityManager() {
        EntityManager em = new Bear().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Bear.countBears() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Bear o", Long.class).getSingleResult();
    }
    
    public static List<Bear> Bear.findAllBears() {
        return entityManager().createQuery("SELECT o FROM Bear o", Bear.class).getResultList();
    }
    
    public static Bear Bear.findBear(Long id) {
        if (id == null) return null;
        return entityManager().find(Bear.class, id);
    }
    
    public static List<Bear> Bear.findBearEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Bear o", Bear.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
