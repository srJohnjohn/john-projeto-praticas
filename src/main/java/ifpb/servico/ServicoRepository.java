/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ads.projeto.praticas.servico;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author recursive
 */
@RequestScoped
public class ServicoRepository {
    
    @PersistenceContext()
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void add(Servico ser){
        em.persist(ser);
    }
    
    public void remove(Servico ser){
        em.remove(ser);
    }
    
    public void update(Servico ser){
        em.merge(ser);
    }
    
    public List<Servico> list(){
        return em.createQuery("SELECT s FROM Servico s", Servico.class).getResultList();
    }
    
    public Servico buscarPorId(int id) {
        return em.find(Servico.class, id);
    }

}
