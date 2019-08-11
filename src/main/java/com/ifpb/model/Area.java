package com.ifpb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Area implements Serializable {

    @Id
    private int codigo;
    private String nome;
    @ManyToOne
    private Publicacao publicacao;

    public Area() {
    }

    public Area(int codigo, String nome, Publicacao publicacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.publicacao = publicacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    @Override
    public String toString() {
        return "Area{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", publicacao=" + publicacao +
                '}';
    }
}
