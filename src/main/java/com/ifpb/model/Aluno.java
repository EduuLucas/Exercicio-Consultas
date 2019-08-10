package com.ifpb.model;

import com.ifpb.converters.LocalDateConverter;
import org.eclipse.persistence.internal.jpa.parsing.TemporalLiteralNode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Aluno extends Pessoa implements Serializable {

    @Id
    private String matricula;
    private String turma;
    @Temporal(TemporalType.DATE)
    @Convert(converter = LocalDateConverter.class)
    private LocalDate dataIngresso;
    @Embedded
    private Endereco endereco;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, int idade, LocalDate dataNascimento, String matricula, String turma, LocalDate dataIngresso, Endereco endereco) {
        super(nome, cpf, idade, dataNascimento);
        this.matricula = matricula;
        this.turma = turma;
        this.dataIngresso = dataIngresso;
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
