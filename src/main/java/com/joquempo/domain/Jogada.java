package com.joquempo.domain;

/**
 * Created by andrepapazoglu on 20/11/16.
 */
public enum Jogada {
    PEDRA(1, "Pedra"), PAPEL(2, "Papel"), TESOURA(3, "Tesoura");

    private int id;
    private String nome;

    Jogada(int i, String nome) {
        this.id = i;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
