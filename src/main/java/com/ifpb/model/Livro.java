package com.ifpb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Livro implements Serializable{

    private String titulo;
    @Id
    private String ISBN;
    @Temporal(TemporalType.DATE)
    private LocalDate lancamento;

    @ManyToMany(mappedBy = "livros")
    private List<Autor> autores;

    public Livro(String titulo, String ISBN, LocalDate lancamento, List<Autor> autores) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.lancamento = lancamento;
        this.autores = autores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
