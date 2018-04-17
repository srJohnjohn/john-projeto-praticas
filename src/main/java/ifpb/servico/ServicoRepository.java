/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.servico;

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
public class ServicoRepository {
    
    @Inject
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void add(Servico ser){
        try {
            em.getTransaction().begin();
            em.persist(ser);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void remove(Servico ser){
        try {
            em.getTransaction().begin();
            em.merge(ser);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void update(Servico ser){
        try {
            em.getTransaction().begin();
            em.merge(ser);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public List<Servico> list(){
        return em.createQuery("SELECT s FROM Servico s", Servico.class).getResultList();
    }
    
    public Servico buscarPorId(long id) {
        return em.find(Servico.class, id);
    }

}
