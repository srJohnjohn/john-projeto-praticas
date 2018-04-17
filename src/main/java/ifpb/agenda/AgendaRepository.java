/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.agenda;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author recursive
 */
@RequestScoped
public class AgendaRepository implements Serializable{
    
    @Inject
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void add(Agenda age){
        em.persist(age);
    }
    
    public void remove(Agenda age){
        em.remove(age);
    }
    
    public void update(Agenda age){
        em.merge(age);
    }
    
    public List<Agenda> list(){
        return em.createQuery("SELECT a FROM Agenda a", Agenda.class).getResultList();
    }
    
    public Agenda buscarPorId(int id) {
        return em.find(Agenda.class, id);
    }

}
