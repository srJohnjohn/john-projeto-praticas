/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.horarioatendimento;

import ifpb.funcionario.FuncionarioController;
import ifpb.servico.Servico;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author recursive
 */
@RequestScoped
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
        try {
            em.getTransaction().begin();
            em.persist(ha);
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.INFO, "cadastrando HorarioAtendimento");
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void remove(HorarioAtendimento ha){
        try {
            em.getTransaction().begin();
            em.remove(ha);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void update(HorarioAtendimento ha){
        try {
            em.getTransaction().begin();
            em.merge(ha);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public List<HorarioAtendimento> list(){
        return em.createQuery("SELECT ha FROM HorarioAtendimento ha", HorarioAtendimento.class).getResultList();
    }
    
    public HorarioAtendimento buscarPorId(long id) {
        return em.find(HorarioAtendimento.class, id);
    }
}
