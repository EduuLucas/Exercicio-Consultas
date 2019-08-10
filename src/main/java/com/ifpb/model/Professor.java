package com.ifpb.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Professor extends Pessoa implements Serializable {

    private Double salario;
    @Embedded
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Telefone> telefones;

    public Professor() {
    }

    public Professor(String nome, String cpf, int idade, LocalDate dataNascimento, Double salario, List<Telefone> telefones, Endereco endereco) {
        super(nome, cpf, idade, dataNascimento);
        this.salario = salario;
        this.telefones = telefones;
        this.endereco = endereco;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
