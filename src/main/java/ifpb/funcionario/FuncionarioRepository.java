/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.funcionario;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author recursive
 */
@RequestScoped
public class FuncionarioRepository {
    
    @Inject
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void add(Funcionario fun){
        Logger.getLogger(FuncionarioRepository.class.getName()).log(Level.INFO, "Percistindo");
        try {
            em.getTransaction().begin();
            em.persist(fun);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
}
        em.persist(fun);
        Logger.getLogger(FuncionarioRepository.class.getName()).log(Level.INFO, "Percistil");
        Logger.getLogger(FuncionarioRepository.class.getName()).log(Level.INFO, String.valueOf(fun.getId()));
    }
    
    public void remove(Funcionario fun){
        try {
            em.getTransaction().begin();
            em.remove(fun);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void update(Funcionario fun){
        em.merge(fun);
    }
    
    public List<Funcionario> list(){
        Logger.getLogger(FuncionarioRepository.class.getName()).log(Level.INFO, "Retornando lista");
        TypedQuery<Funcionario> query = em.createQuery("Select f From Funcionario f", Funcionario.class);
        Logger.getLogger(FuncionarioRepository.class.getName()).log(Level.INFO, String.valueOf(query.getResultList().size()));
        return query.getResultList();
    }
    
    public Funcionario buscarPorId(long id) {
        return em.find(Funcionario.class, id);
    }
    
    public Funcionario buscarPorNome(String nome) {
        List<Funcionario> funcionarios = list();
        Funcionario fun = null;
        Logger.getLogger(FuncionarioRepository.class.getName()).log(Level.INFO, String.valueOf(funcionarios.size()));
        for (Funcionario funcionario : funcionarios) {
            Logger.getLogger(FuncionarioRepository.class.getName()).log(Level.INFO, "interando Sobre a lista");
            if (funcionario.getNome() == null ? nome == null : funcionario.getNome().equals(nome)){
                Logger.getLogger(FuncionarioRepository.class.getName()).log(Level.INFO, "encontrado o funcionario");
                fun = funcionario;
            }
        }
        return fun;
    }
    
}
