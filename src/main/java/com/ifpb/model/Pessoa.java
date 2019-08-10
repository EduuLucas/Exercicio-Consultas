package com.ifpb.model;

import com.ifpb.converters.LocalDateConverter;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public class Pessoa {

    private String nome;
    @Id
    private String cpf;
    private int idade;
    @Temporal(TemporalType.DATE)
    @Convert(converter = LocalDateConverter.class)
    private LocalDate dataNascimento;

    public Pessoa(String nome, String cpf, int idade, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
