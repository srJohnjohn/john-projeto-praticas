/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.funcionario;

import ifpb.atendimento.Atendimento;
import ifpb.atendimento.AtendimentoService;
import ifpb.cliente.ClienteServece;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author recursive
 */
@RequestScoped
public class FuncionarioServece {
    
    @Inject
    private FuncionarioRepository cr;
    @Inject
    private AtendimentoService as;
    
    public void add(Funcionario fun){
        if(cr.buscarPorNome(fun.getNome()) == null){
            cr.add(fun);
        }
    }
    
    public void remove(Funcionario fun){
        cr.remove(fun);
    }
    
    public void update(Funcionario fun){
        cr.update(fun);
    }
    
    public List<Funcionario> list(){
        return cr.list();
    }
    
    public Funcionario buscarPorId(long id) {
        return cr.buscarPorId(id);
    }
    
    public Funcionario buscarPorNome(String nome) {
        return cr.buscarPorNome(nome);
    }

    public boolean logar(Funcionario fun){
        Funcionario f = buscarPorNome(fun.getNome());
        return f != null;
    }
    
    public void desmarcar(long id, Funcionario fun){
        Atendimento ate;
        ate = as.buscarId(id);
        as.remove(ate);
    }
    
}
