/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.auxiliares;

import ifpb.agenda.Agenda;
import ifpb.atendimento.Atendimento;
import ifpb.funcionario.Funcionario;
import ifpb.horarioatendimento.HorarioAtendimento;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author recursive
 */
public class CordenadorHorarios {
    
    public static HorarioAtendimento horariosVagos(Funcionario fun, LocalDate dia){
        Agenda age = fun.getMinhaAgenda();
        List<Atendimento> ateDodia = new ArrayList<>();
        for (Atendimento ate : age.getAtendimentos()) {
            if(ate.getDia().equals(dia)){
                ateDodia.add(ate);
            }
        }
        Atendimento utimo = ateDodia.get(0);
        
        for (Atendimento atendimento : ateDodia) {
            if(!utimo.getInicio().isAfter(atendimento.getInicio())){
                utimo = atendimento;
            }
        }
        HorarioAtendimento hoje = null;
        for (HorarioAtendimento ha : fun.getMinhaAgenda().getHorarios()) {
            if(ha.getDia() == dia){
                hoje = ha;
            }
        }
        LocalTime fimutimo;
        fimutimo = utimo.getInicio().plusMinutes(utimo.getSev().getDuracao().getMinute());
        HorarioAtendimento ha = new HorarioAtendimento(0, fun,dia.getDayOfWeek(), dia, fimutimo, hoje.getSaida());
        return ha;
    }
    
}
