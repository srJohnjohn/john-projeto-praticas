/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ads.projeto.praticas.cliente;

import ads.projeto.praticas.agenda.Agenda;
import ads.projeto.praticas.funcionario.Funcionario;
import ads.projeto.praticas.funcionario.FuncionarioServece;
import ads.projeto.praticas.horarioatendimento.HorarioAtendimento;
import ads.projeto.praticas.servico.Servico;
import ifpb.auxiliares.CordenadorHorarios;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author recursive
 */
@RequestScoped
public class ClienteServece {
    
    @Inject
    private ClineteRepository cr;
    
    
    public void add(Cliente cli){
        cr.buscarPorNome(cli.getNome());
        cr.add(cli);
    }
    
    public void remove(Cliente cli){
        cr.remove(cli);
    }
    
    public void update(Cliente cli){
        cr.update(cli);
    }
    
    public List<Cliente> list(){
        return cr.list();
    }
    
    public Cliente buscarPorId(int id) {
        return cr.buscarPorId(id);
    }
    
    public Cliente buscarPorNome(String nome) {
        return cr.buscarPorNome(nome);
    }

    public boolean logar(Cliente cli){
        Cliente c = buscarPorNome(cli.getNome());
        return c != null;
    }
    
    public List<HorarioAtendimento> HAFuncionarios(LocalDate dia, FuncionarioServece fs){
        List<HorarioAtendimento> horarios = new ArrayList<>();
        for (Funcionario funcionario : fs.list()) {
            horarios.add(CordenadorHorarios.horariosVagos(funcionario, dia));
        }
        return horarios;
    }
    
    public HorarioAtendimento HAFuncionario(LocalDate dia, Funcionario fun){
        HorarioAtendimento horarios = CordenadorHorarios.horariosVagos(fun, dia);
        return horarios;
    }
    
}
