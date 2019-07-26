package com.ifpb.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Livro implements Serializable{

    private String titulo;
    private String ISBN;
    private LocalDate lancamento;

    public Livro(String titulo, String ISBN, LocalDate lancamento) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.lancamento = lancamento;
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
}
