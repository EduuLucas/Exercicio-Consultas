package com.ifpb.model;

import org.eclipse.persistence.internal.jpa.parsing.TemporalLiteralNode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Aluno extends Pessoa implements Serializable {

    private String matricula;
    private String turma;
    @Temporal(TemporalType.DATE)
    private LocalDate dataIngresso;

    public Aluno(String nome, String cpf, int idade, LocalDate dataNascimento, String matricula, String turma, LocalDate dataIngresso) {
        super(nome, cpf, idade, dataNascimento);
        this.matricula = matricula;
        this.turma = turma;
        this.dataIngresso = dataIngresso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
}
