/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.funcionario;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author recursive
 */
@RequestScoped
public class FuncionarioRepository {
    
    @PersistenceContext()
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void add(Funcionario fun){
        em.persist(fun);
    }
    
    public void remove(Funcionario fun){
        em.remove(fun);
    }
    
    public void update(Funcionario fun){
        em.merge(fun);
    }
    
    public List<Funcionario> list(){
        return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
    }
    
    public Funcionario buscarPorId(long id) {
        return em.find(Funcionario.class, id);
    }
    
    public Funcionario buscarPorNome(String nome) {
        List<Funcionario> funcionarios = list();
        Funcionario fun = null;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome() == null ? nome == null : funcionario.getNome().equals(nome)){
                fun = funcionario;
            }
        }
        return fun;
    }
    
}
