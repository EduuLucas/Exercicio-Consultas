package com.ifpb.model;

import com.ifpb.model.Enum.TelefoneType;

import java.io.Serializable;

public class Telefone implements Serializable {

    private String numero;
    private TelefoneType tipo;

    public Telefone(String numero, TelefoneType tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneType getTipo() {
        return tipo;
    }

    public void setTipo(TelefoneType tipo) {
        this.tipo = tipo;
    }
}
