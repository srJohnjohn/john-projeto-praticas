/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.horarioatendimento;

import ifpb.servico.Servico;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author recursive
 */
public class HorarioAtendimentoRepository {
    
    @Inject
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void add(HorarioAtendimento ha){
        em.persist(ha);
    }
    
    public void remove(HorarioAtendimento ha){
        em.remove(ha);
    }
    
    public void update(HorarioAtendimento ha){
        em.merge(ha);
    }
    
    public List<HorarioAtendimento> list(){
        return em.createQuery("SELECT ha FROM HorarioAtendimento ha", HorarioAtendimento.class).getResultList();
    }
    
    public HorarioAtendimento buscarPorId(long id) {
        return em.find(HorarioAtendimento.class, id);
    }
}
