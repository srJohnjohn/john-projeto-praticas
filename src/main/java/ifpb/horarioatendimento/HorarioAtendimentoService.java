/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.horarioatendimento;

import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author recursive
 */
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
    
}
