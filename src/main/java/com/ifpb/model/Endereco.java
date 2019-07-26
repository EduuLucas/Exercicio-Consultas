package com.ifpb.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {

    private String rua;
    private String cidade;
    private String CEP;
    private String bairro;

    public Endereco(String rua, String cidade, String CEP, String bairro) {
        this.rua = rua;
        this.cidade = cidade;
        this.CEP = CEP;
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
