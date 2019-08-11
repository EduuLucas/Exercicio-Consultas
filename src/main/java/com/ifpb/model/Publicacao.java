package com.ifpb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Publicacao implements Serializable {

    @Id
    private int codigo;

    private String titulo;

    @ManyToOne
    private Escritor escritor;

    @ManyToOne
    private Revisor revisor;

    @OneToMany(mappedBy="publicacao",cascade={CascadeType.ALL})
    private List<Area> areas;

    public Publicacao() {
    }

    public Publicacao(int codigo, String titulo, Escritor escritor, Revisor revisor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.escritor = escritor;
        this.revisor = revisor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", escritor=" + escritor +
                ", revisor=" + revisor +
                '}';
    }
}
