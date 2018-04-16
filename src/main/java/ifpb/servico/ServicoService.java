/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tsrplate file, choose Tools | Tsrplates
 * and open the tsrplate in the editor.
 */
package ads.projeto.praticas.servico;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author recursive
 */
@RequestScoped
public class ServicoService implements Serializable{
    
    @Inject
    private ServicoRepository sr;

    public ServicoRepository getSr() {
        return sr;
    }

    public void setSr(ServicoRepository sr) {
        this.sr = sr;
    }
    
    public void add(Servico ser){
        sr.add(ser);
    }
    
    public void remove(Servico ser){
        sr.remove(ser);
    }
    
    public void update(Servico ser){
        sr.update(ser);
    }
    
    public List<Servico> list(){
        return sr.list();
    }
    
    public Servico buscarPorId(int id) {
        return sr.buscarPorId(id);
    }

}
