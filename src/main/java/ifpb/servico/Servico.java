/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.servico;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author ifpb
 */
@Entity
public class Servico implements Serializable{
    
    @Id
    @GeneratedValue
    private long id;
    private LocalTime duracao;
    private long perco;
    private TipoServico tipo;

    public Servico() {
    }

    public Servico(long id, LocalTime duracao, long perco, TipoServico tipo) {
        this.id = id;
        this.duracao = duracao;
        this.perco = perco;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getDuracao() {
        return duracao;
    }

    public void setDuracao(LocalTime duracao) {
        this.duracao = duracao;
    }

    public long getPerco() {
        return perco;
    }

    public void setPerco(long perco) {
        this.perco = perco;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public void setTipo(TipoServico tipo) {
        this.tipo = tipo;
    }

}
