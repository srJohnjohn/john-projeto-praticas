/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.atendimento;

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
public class AtendimentoRepository implements Serializable{
    
    @Inject
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void add(Atendimento ate){
        try {
            em.getTransaction().begin();
            em.persist(ate);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void remove(Atendimento ate){
        try {
            em.getTransaction().begin();
            em.remove(ate);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void update(Atendimento ate){
        try {
            em.getTransaction().begin();
            em.merge(ate);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public List<Atendimento> list(){
        return em.createQuery("SELECT a FROM Atendimento a", Atendimento.class).getResultList();
    }
    
    public Atendimento buscarPorId(long id) {
        return em.find(Atendimento.class, id);
    }

}
