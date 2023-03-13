package Entites;

import EntitesEnum.Level;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {

    private String nome;
    private Level level;
    private Double salario;
    private Departamento departamento;
    // Como um trabalhador pode ter varios contratos, o Classe é representada com uma lista;
    private List<ContratoPorHora> contratos =  new ArrayList<ContratoPorHora>();

    public Trabalhador(){

    }

    public Trabalhador(String nome, Level level, Double salario, Departamento departamento) {
        this.nome = nome;
        this.level = level;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoPorHora> getContratos() {
        return contratos;
    }

    public void addContrato(ContratoPorHora contrato){
        this.contratos.add(contrato);
    }

    public void remvContrato(ContratoPorHora contrato){
        this.contratos.remove(contrato);
    }

    public double renda(int ano, int mes){
        double soma = salario;
        Calendar cal = Calendar.getInstance();
        for (ContratoPorHora c:contratos) {
            cal.setTime(c.getData());
            int c_ano = cal.get(Calendar.YEAR);
            int c_mes = cal.get(Calendar.MONTH);
            if (c_ano == ano && c_mes == mes){
                soma += c.valorTotal();
            }
        }
        return soma;
    }
}
