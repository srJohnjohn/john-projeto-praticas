/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.funcionario;

import ifpb.agenda.Agenda;
import ifpb.servico.Servico;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author ifpb
 */
@Entity
public class Funcionario implements Serializable{

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String senha;
    @OneToOne
    private Agenda minhaAgenda;
    @OneToMany
    private List<Servico> servicos;

    public Funcionario() {
    }

    public Funcionario(long id, String nome, String senha, Agenda minhaAgenda, List<Servico> servicos) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.minhaAgenda = minhaAgenda;
        this.servicos = servicos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Agenda getMinhaAgenda() {
        return minhaAgenda;
    }

    public void setMinhaAgenda(Agenda minhaAgenda) {
        this.minhaAgenda = minhaAgenda;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
    
}
