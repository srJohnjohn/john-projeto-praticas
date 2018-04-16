/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.agenda;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author recursive
 */
@RequestScoped
public class AgendaService implements Serializable{
    
    @Inject
    private AgendaRepository sr;

    public AgendaRepository getSr() {
        return sr;
    }

    public void setSr(AgendaRepository sr) {
        this.sr = sr;
    }
    
    public void add(Agenda age){
        sr.add(age);
    }
    
    public void remove(Agenda age){
        sr.remove(age);
    }
    
    public void update(Agenda age){
        sr.update(age);
    }
    
    public List<Agenda> list(){
        return sr.list();
    }
    
    public Agenda buscarPorId(int id) {
        return sr.buscarPorId(id);
    }
}
