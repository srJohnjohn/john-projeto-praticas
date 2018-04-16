/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ads.projeto.praticas.agenda;

import ads.projeto.praticas.horarioatendimento.HorarioAtendimento;
import ads.projeto.praticas.atendimento.Atendimento;
import ads.projeto.praticas.funcionario.Funcionario;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 *
 * @author ifpb
 */
@Entity
public class Agenda implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private List<HorarioAtendimento> horarios;
    @ManyToOne
    private List<Atendimento> atendimentos;

    public Agenda(long id, List<HorarioAtendimento> horarios, List<Atendimento> atendimentos) {
        this.id = id;
        this.horarios = horarios;
        this.atendimentos = atendimentos;
    }

    public Agenda() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<HorarioAtendimento> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioAtendimento> horarios) {
        this.horarios = horarios;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

}
