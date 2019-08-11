package com.ifpb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Revisor extends Pessoa implements Serializable {

    private String nota;

    @OneToMany(mappedBy = "revisor", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Publicacao> publicacoes;

    public Revisor() {
    }

    public Revisor(int id, String nome, LocalDate dataNascimento, String nota) {
        super(id, nome, dataNascimento);
        this.nota = nota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Revisor{" +
                "nota='" + nota + '\'' +
                '}';
    }
}
