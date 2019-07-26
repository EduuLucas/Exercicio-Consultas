package com.ifpb.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Professor extends Pessoa implements Serializable {

    private Double salario;

    public Professor(String nome, String cpf, int idade, LocalDate dataNascimento, Double salario) {
        super(nome, cpf, idade, dataNascimento);
        this.salario = salario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
