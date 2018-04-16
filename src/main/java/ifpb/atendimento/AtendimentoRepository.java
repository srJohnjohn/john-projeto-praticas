/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ads.projeto.praticas.atendimento;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author recursive
 */
@RequestScoped
public class AtendimentoRepository implements Serializable{
    
    @PersistenceContext()
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void add(Atendimento ate){
        em.persist(ate);
    }
    
    public void remove(Atendimento ate){
        em.remove(ate);
    }
    
    public void update(Atendimento ate){
        em.merge(ate);
    }
    
    public List<Atendimento> list(){
        return em.createQuery("SELECT a FROM Atendimento a", Atendimento.class).getResultList();
    }
    
    public Atendimento buscarPorId(long id) {
        return em.find(Atendimento.class, id);
    }

}
