/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ads.projeto.praticas.agenda;

import ads.projeto.praticas.atendimento.Atendimento;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author recursive
 */
@RequestScoped
public class GerenciadorAgenda implements Serializable{
    
    public static void addAtendimento(Agenda age, Atendimento ate){
        age.getAtendimentos().add(ate);
    }
    
    public static void removerAtendimento(Agenda age, Atendimento ate){
        age.getAtendimentos().remove(ate);
    }
    
    public static void concluirAtendimento(Agenda age, Atendimento ate){
        
    }
    
}
