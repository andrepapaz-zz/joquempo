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

}
