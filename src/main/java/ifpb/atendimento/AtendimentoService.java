/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.atendimento;

import ifpb.cliente.Cliente;
import ifpb.funcionario.Funcionario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author recursive
 */
@RequestScoped
public class AtendimentoService implements Serializable{
    
    @Inject
    private AtendimentoRepository ar;
    
    public void add(Atendimento ate){
        List<Atendimento> atendimentos = this.list();
        for (Atendimento atendimento : atendimentos) {
            if(ate.getDia().equals(atendimento.getDia())){
                if((!ate.getInicio().isAfter(atendimento.getInicio().plusMinutes(atendimento.getSev().getDuracao().getMinute()))) || (!ate.getInicio().isBefore(atendimento.getInicio()))){
                    return;
                }
            }
        }
        ar.add(ate);
    }
    
    public void remove(Atendimento ate){
        ar.remove(ate);
    }

    public void update(Atendimento ate){
        ar.update(ate);
    }
    
    public List<Atendimento> list(){
        return ar.list();
    }
    
    public Atendimento buscarId(long id){
        return ar.buscarPorId(id);
    }
    
    public List<Atendimento> atendimentosCliente(Cliente cli){
        List<Atendimento> atendimentos = new ArrayList<>();
        for (Atendimento atendimento : list()) {
            if(atendimento.getCliente().getNome().equals(cli.getNome())){
                atendimentos.add(atendimento);
            }
        }
        return atendimentos;
    }
    
    public List<Atendimento> atendimentosFuncionario(Funcionario fun){
        List<Atendimento> atendimentos = new ArrayList<>();
        for (Atendimento atendimento : list()) {
            if(atendimento.getCliente().getNome().equals(fun.getNome())){
                atendimentos.add(atendimento);
            }
        }
        return atendimentos;
    }
}
