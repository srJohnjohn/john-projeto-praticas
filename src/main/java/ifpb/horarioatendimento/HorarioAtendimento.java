/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.horarioatendimento;

import ifpb.funcionario.Funcionario;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ifpb
 */
@Entity
public class HorarioAtendimento implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Funcionario fun;
    private DayOfWeek diaSemana;
    private LocalDate dia;
    private LocalTime chegada;
    private LocalTime Saida;

    public HorarioAtendimento() {
    }

    public HorarioAtendimento(long id, Funcionario fun, DayOfWeek diaSemana, LocalDate dia, LocalTime chegada, LocalTime Saida) {
        this.id = id;
        this.fun = fun;
        this.diaSemana = diaSemana;
        this.dia = dia;
        this.chegada = chegada;
        this.Saida = Saida;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Funcionario getFun() {
        return fun;
    }

    public void setFun(Funcionario fun) {
        this.fun = fun;
    }

    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getChegada() {
        return chegada;
    }

    public void setChegada(LocalTime chegada) {
        this.chegada = chegada;
    }

    public LocalTime getSaida() {
        return Saida;
    }

    public void setSaida(LocalTime Saida) {
        this.Saida = Saida;
    }

}