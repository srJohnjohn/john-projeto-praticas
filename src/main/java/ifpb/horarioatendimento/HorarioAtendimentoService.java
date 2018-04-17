/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.horarioatendimento;

import ifpb.funcionario.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author recursive
 */
@RequestScoped
public class HorarioAtendimentoService {
    
    @Inject
    private HorarioAtendimentoRepository har;

    public HorarioAtendimentoRepository getSr() {
        return har;
    }

    public void setSr(HorarioAtendimentoRepository har) {
        this.har = har;
    }
    
    public void add(HorarioAtendimento ha){
        this.har.add(ha);
    }
    
    public void remove(HorarioAtendimento ha){
        har.remove(ha);
    }
    
    public void update(HorarioAtendimento ha){
        har.update(ha);
    }
    
    public List<HorarioAtendimento> list(){
        return har.list();
    }
    
    public HorarioAtendimento buscarPorId(int id) {
        return har.buscarPorId(id);
    }
    
    public List<HorarioAtendimento> horariosFuncionario(Funcionario fun){
        List<HorarioAtendimento> ha = new ArrayList<>();
        for (HorarioAtendimento horarioAtendimento : list()) {
            if(horarioAtendimento.getFun().getNome().equals(fun.getNome())){
                ha.add(horarioAtendimento);
            }
        }
        return ha;
    }
    
}
