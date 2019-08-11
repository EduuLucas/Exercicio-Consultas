package com.ifpb.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Escritor extends Pessoa implements Serializable {

    private int premios;

    @OneToMany(mappedBy = "escritor", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Publicacao> publicacoes;

    public Escritor() {
    }

    public Escritor(int id, String nome, LocalDate dataNascimento, int premios) {
        super(id, nome, dataNascimento);
        this.premios = premios;
    }

    public int getPremios() {
        return premios;
    }

    public void setPremios(int premios) {
        this.premios = premios;
    }

    @Override
    public String toString() {
        return "Escritor{" +
                "premios=" + premios +
                '}';
    }
}
