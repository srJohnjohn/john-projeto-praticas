/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.funcionario;

import ifpb.atendimento.Atendimento;
import ifpb.atendimento.AtendimentoService;
import ifpb.cliente.ClienteServece;
import ifpb.horarioatendimento.HorarioAtendimento;
import ifpb.servico.Servico;
import ifpb.servico.ServicoService;
import ifpb.horarioatendimento.HorarioAtendimentoService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author recursive
 */
@Named
@RequestScoped
public class FuncionarioController implements Serializable{
    
    @Inject
    private FuncionarioServece fs;
    @Inject
    private ServicoService ss;
    @Inject
    private AtendimentoService as;
    @Inject
    private ClienteServece cs;
    @Inject
    private HorarioAtendimentoService has;
    private Funcionario funcionario;
    private Funcionario logado;
    private Servico servico = new Servico();
    private Atendimento ate = new Atendimento();
    private HorarioAtendimento ha = new HorarioAtendimento();

    public HorarioAtendimentoService getHas() {
        return has;
    }

    public void setHas(HorarioAtendimentoService has) {
        this.has = has;
    }

    public ClienteServece getCs() {
        return cs;
    }

    public void setCs(ClienteServece cs) {
        this.cs = cs;
    }

    public HorarioAtendimento getHa() {
        return ha;
    }

    public void setHa(HorarioAtendimento ha) {
        this.ha = ha;
    }

    public AtendimentoService getAs() {
        return as;
    }

    public void setAs(AtendimentoService as) {
        this.as = as;
    }

    public Atendimento getAte() {
        return ate;
    }

    public void setAte(Atendimento ate) {
        this.ate = ate;
    }

    public ServicoService getSs() {
        return ss;
    }

    public void setSs(ServicoService ss) {
        this.ss = ss;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    public FuncionarioServece getFs() {
        return fs;
    }

    public void setFs(FuncionarioServece fs) {
        this.fs = fs;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getLogado() {
        return logado;
    }

    public void setLogado(Funcionario logado) {
        this.logado = logado;
    }
    
    public void cadastrarFuncionario(){
        fs.add(funcionario);
    }
    
    public String logar(){
        if(fs.logar(funcionario)){
            this.logado = this.funcionario;
            return "home";
        }
        return "index";
    }
    
    public void cadastrarServico(){
        ss.add(servico);
    }
    
    public String Agendar(){
        this.ate.setFun(logado);
        this.ate.setCliente(cs.buscarPorNome(ate.getCliente().getNome()));
        this.as.add(ate);
        ate = new Atendimento();
        return "home.xhtml";
    }
    
    public String desmarcar(long ate){
        this.fs.desmarcar(ate, logado);
        return "home.xhtml";
    }
    
    public void criarHA(){
        ha.setDiaSemana(ha.getDia().getDayOfWeek());
        ha.setFun(logado);
        this.has.add(ha);
    }
    
}
