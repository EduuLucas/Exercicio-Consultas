package com.ifpb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Autor extends Pessoa implements Serializable {

    private String instituicaoVinculada;
    @Embedded
    private Endereco endereco;

    @ManyToMany
    @JoinTable(name="autorLivro",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id"))
    private List<Livro> livros;

    public Autor() {
    }

    public Autor(String nome, String cpf, int idade, LocalDate dataNascimento, String instituicaoVinculada, Endereco endereco, List<Livro> livros) {
        super(nome, cpf, idade, dataNascimento);
        this.instituicaoVinculada = instituicaoVinculada;
        this.livros = livros;
        this.endereco = endereco;
    }

    public String getInstituicaoVinculada() {
        return instituicaoVinculada;
    }

    public void setInstituicaoVinculada(String instituicaoVinculada) {
        this.instituicaoVinculada = instituicaoVinculada;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
