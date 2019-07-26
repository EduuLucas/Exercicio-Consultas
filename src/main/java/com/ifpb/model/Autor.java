package com.ifpb.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Autor extends Pessoa implements Serializable {

    private String instituicaoVinculada;

    public Autor(String nome, String cpf, int idade, LocalDate dataNascimento, String instituicaoVinculada) {
        super(nome, cpf, idade, dataNascimento);
        this.instituicaoVinculada = instituicaoVinculada;
    }

    public String getInstituicaoVinculada() {
        return instituicaoVinculada;
    }

    public void setInstituicaoVinculada(String instituicaoVinculada) {
        this.instituicaoVinculada = instituicaoVinculada;
    }
}
