/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.funcionario;

import ifpb.agenda.Agenda;
import ifpb.atendimento.Atendimento;
import ifpb.atendimento.AtendimentoService;
import ifpb.cliente.ClienteServece;
import ifpb.horarioatendimento.HorarioAtendimento;
import ifpb.servico.Servico;
import ifpb.servico.ServicoService;
import ifpb.horarioatendimento.HorarioAtendimentoService;
import ifpb.servico.TipoServico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author recursive
 */
@Named
@SessionScoped
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
    private TipoServico[] ts;

    public TipoServico[] getTs() {
        return TipoServico.values();
    }

    public void setTs(TipoServico[] ts) {
        this.ts = TipoServico.values();
    }
    

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
        Logger.getLogger(FuncionarioController.class.getName()).log(Level.INFO, "Cadastrando");
        fs.add(funcionario);
        this.funcionario = new Funcionario();
    }
    
    public String logar(){
        if(this.funcionario.getNome() != null){
            this.logado = fs.buscarPorNome(this.funcionario.getNome());
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.INFO, "Conseguil buscar no banco");
            if((this.logado != null) && (this.funcionario.getSenha().equals(this.logado.getSenha()))){
                Logger.getLogger(FuncionarioController.class.getName()).log(Level.INFO, "Passo do utimo if");
                
                Agenda agenda = new Agenda();
                agenda.setAtendimentos(as.atendimentosFuncionario(logado));
                agenda.setHorarios(has.horariosFuncionario(logado));
                logado.setMinhaAgenda(agenda);
                
                HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                sessao.setAttribute("funcionario", logado);
                Logger.getLogger(FuncionarioController.class.getName()).log(Level.INFO, "logado");
                return "homefuncionario.xhtml?faces-redirect=true";
            }
        }
        this.logado = null;
        Logger.getLogger(FuncionarioController.class.getName()).log(Level.INFO, "Erro ao logar");
        return "loginfuncionario.xhtml?faces-redirect=true";
    }
    
    public String logout(){
        this.logado = new Funcionario();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "indexfuncionario.xhtml?faces-redirect=true";
    }
    
    public void cadastrarServico(){
        Logger.getLogger(FuncionarioController.class.getName()).log(Level.INFO, servico.getTipo().toString());
        ss.add(servico);
        logado.setServicos(ss.list());
        servico = new Servico();
    }
    
    public String Agendar(){
        this.ate.setFun(logado);
        this.ate.setCliente(cs.buscarPorNome(ate.getCliente().getNome()));
        this.as.add(ate);
        this.logado.getMinhaAgenda().setAtendimentos(as.atendimentosFuncionario(logado));
        ate = new Atendimento();
        return "homefuncionario.xhtml?faces-redirect=true";
    }
    
    public String desmarcar(long ate){
        this.fs.desmarcar(ate, logado);
        return "homefuncionario.xhtml?faces-redirect=true";
    }
    
    public String criarHA(){
        ha.setDiaSemana(ha.getDia().getDayOfWeek());
        ha.setFun(logado);
        this.has.add(ha);
        Logger.getLogger(FuncionarioController.class.getName()).log(Level.INFO, logado.toString());
        Logger.getLogger(FuncionarioController.class.getName()).log(Level.INFO, String.valueOf(logado.getMinhaAgenda().getHorarios().size()));
        this.logado.getMinhaAgenda().setHorarios(has.horariosFuncionario(logado));
        this.ha = new HorarioAtendimento();
        return "homefuncionario.xhtml?faces-redirect=true";
    }
    
    @PostConstruct
    public void inicio(){
        servico = new Servico();
        ate = new Atendimento();
        ha = new HorarioAtendimento();
        funcionario = new Funcionario();
    }
    
}
