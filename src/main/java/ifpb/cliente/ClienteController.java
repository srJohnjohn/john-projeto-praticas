/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.cliente;

import ifpb.atendimento.Atendimento;
import ifpb.atendimento.AtendimentoService;
import ifpb.funcionario.Funcionario;
import ifpb.funcionario.FuncionarioController;
import ifpb.funcionario.FuncionarioServece;
import ifpb.horarioatendimento.HorarioAtendimento;
import ifpb.servico.Servico;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author recursive
 */
@Named
@SessionScoped
public class ClienteController implements Serializable{
    
    @Inject
    private ClienteServece cs;
    @Inject
    private FuncionarioServece fs;
    @Inject
    private AtendimentoService as;
    private Cliente cliente;
    private Cliente logado;
    private List<Funcionario> funcionarios;
    private List<Servico> servicos;
    private List<HorarioAtendimento> has;
    private LocalDate dia;
    private Funcionario fun;
    private HorarioAtendimento haf;
    private Atendimento ate;
    private List<Atendimento> meusAtendimentos;

    public List<Atendimento> getMeusAtendimentos() {
        return meusAtendimentos;
    }

    public void setMeusAtendimentos(List<Atendimento> meusAtendimentos) {
        this.meusAtendimentos = as.atendimentosCliente(logado);
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

    public HorarioAtendimento getHaf() {
        return haf;
    }

    public void setHaf(HorarioAtendimento haf) {
        this.haf = haf;
    }

    public Funcionario getFun() {
        return fun;
    }

    public void setFun(Funcionario fun) {
        this.fun = fun;
    }

    public List<HorarioAtendimento> getHas() {
        return has;
    }

    public void setHas(List<HorarioAtendimento> has) {
        this.has = has;
    }
    

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public FuncionarioServece getFs() {
        return fs;
    }

    public void setFs(FuncionarioServece fs) {
        this.fs = fs;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public ClienteServece getCs() {
        return cs;
    }

    public void setCs(ClienteServece cs) {
        this.cs = cs;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getLogado() {
        return logado;
    }

    public void setLogado(Cliente logado) {
        this.logado = logado;
    }
    
    public void Cadastrar(){
        cs.add(cliente);
    }
    
    public String logar(){
        if(cs.logar(cliente)){
            this.logado = this.cliente;
            return "home";
        }
        return "index";
    }
    
    public void proxFuns(){
        this.dia = dia.plusDays(1);
        this.has = cs.HAFuncionarios(dia, fs);
    }
    
    public void anteFuns(){
        this.dia = dia.minusDays(1);
        this.has = cs.HAFuncionarios(dia, fs);
    }
    
    @PostConstruct
    public void inicio(){
        this.dia = LocalDate.now();
        funcionarios = new ArrayList<>();
        servicos = new ArrayList<>();
        this.has = new ArrayList<>();
        fun = new Funcionario();
    }
    
    public void proxFun(){
        this.dia = dia.plusDays(1);
        this.haf = cs.HAFuncionario(dia, this.fun);
        
    }
    
    public void anteFun(){
        this.dia = dia.minusDays(1);
        this.haf = cs.HAFuncionario(dia, this.fun);
    }
    
    public void buscarFuncionarioNome(){
        fun = fs.buscarPorNome(fun.getNome());
    }
    
    public void cadastrarAtendimento(){
        as.add(ate);
    }
    
    public void desmarcar(long ate){
        Atendimento a = as.buscarId(ate);
        as.remove(a);
    }
    
}
