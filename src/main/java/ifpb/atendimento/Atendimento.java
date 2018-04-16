/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.atendimento;

import ifpb.cliente.Cliente;
import ifpb.funcionario.Funcionario;
import ifpb.servico.Servico;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author ifpb
 */
@Entity
public class Atendimento implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Servico sev;
    @ManyToOne
    private Funcionario fun;
    @ManyToOne
    private Cliente cliente;
    private LocalDate dia;
    private LocalTime inicio;

    public Atendimento() {
    }

    public Atendimento(long id, Servico sev, Funcionario fun, Cliente cliente, LocalDate dia, LocalTime inicio) {
        this.id = id;
        this.sev = sev;
        this.fun = fun;
        this.cliente = cliente;
        this.dia = dia;
        this.inicio = inicio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Servico getSev() {
        return sev;
    }

    public void setSev(Servico sev) {
        this.sev = sev;
    }

    public Funcionario getFun() {
        return fun;
    }

    public void setFun(Funcionario fun) {
        this.fun = fun;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }
}