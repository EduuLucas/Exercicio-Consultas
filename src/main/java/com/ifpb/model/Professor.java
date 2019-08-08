package com.ifpb.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Professor extends Pessoa implements Serializable {

    private Double salario;

    @OneToMany(mappedBy = "professor",cascade = CascadeType.PERSIST)
    private List<Telefone> telefones;

    public Professor(String nome, String cpf, int idade, LocalDate dataNascimento, Double salario, List<Telefone> telefones) {
        super(nome, cpf, idade, dataNascimento);
        this.salario = salario;
        this.telefones = telefones;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
