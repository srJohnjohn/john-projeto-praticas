/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.cliente;

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
public class ClineteRepository {
    
    @Inject
    private EntityManager em;
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public void add(Cliente cli){
        try {
            em.getTransaction().begin();
            em.persist(cli);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void remove(Cliente cli){
        try {
            em.getTransaction().begin();
            em.remove(cli);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void update(Cliente cli){
        try {
            em.getTransaction().begin();
            em.merge(cli);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public List<Cliente> list(){
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }
    
    public Cliente buscarPorId(int id) {
        return em.find(Cliente.class, id);
    }
    
    public Cliente buscarPorNome(String nome) {
        List<Cliente> clientes = list();
        Cliente cli = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome() == null ? nome == null : cliente.getNome().equals(nome)){
                cli = cliente;
            }
        }
        return cli;
    }
    
}
