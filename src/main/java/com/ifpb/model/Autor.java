package com.ifpb.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Autor extends Pessoa implements Serializable {

    private String instituicaoVinculada;

    @ManyToMany
    @JoinTable(name="autorLivro",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id") )
    private List<Livro> livros;

    public Autor(String nome, String cpf, int idade, LocalDate dataNascimento, String instituicaoVinculada, List<Livro> livros) {
        super(nome, cpf, idade, dataNascimento);
        this.instituicaoVinculada = instituicaoVinculada;
        this.livros = livros;
    }

    public String getInstituicaoVinculada() {
        return instituicaoVinculada;
    }

    public void setInstituicaoVinculada(String instituicaoVinculada) {
        this.instituicaoVinculada = instituicaoVinculada;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
