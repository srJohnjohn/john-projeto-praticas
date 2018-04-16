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
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

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
    private Servico servico;
    private Atendimento ate;
    private HorarioAtendimento ha;

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
        if(this.funcionario.getNome() != null){
            this.logado = fs.buscarPorNome(this.funcionario.getNome());
            if((this.logado != null) && (this.funcionario.getSenha().equals(this.logado.getSenha()))){
                HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                sessao.setAttribute("funcionario", logado);
                return "homefuncionario.xhtml?faces-redirect=true";
            }
        }
        return "loginfuncionario.xhtml?faces-redirect=true";
    }
    
    public String logout(){
        this.logado = new Funcionario();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "indexfuncionario.xhtml?faces-redirect=true";
    }
    
    public void cadastrarServico(){
        ss.add(servico);
    }
    
    public String Agendar(){
        this.ate.setFun(logado);
        this.ate.setCliente(cs.buscarPorNome(ate.getCliente().getNome()));
        this.as.add(ate);
        ate = new Atendimento();
        return "homefuncionario.xhtml?faces-redirect=true";
    }
    
    public String desmarcar(long ate){
        this.fs.desmarcar(ate, logado);
        return "homefuncionario.xhtml?faces-redirect=true";
    }
    
    public void criarHA(){
        ha.setDiaSemana(ha.getDia().getDayOfWeek());
        ha.setFun(logado);
        this.has.add(ha);
    }
    
    @PostConstruct
    public void inicio(){
        logado = new Funcionario();
        servico = new Servico();
        ate = new Atendimento();
        ha = new HorarioAtendimento();
        funcionario = new Funcionario();
    }
    
}
