package com.joquempo.domain;

import java.util.Random;

/**
 * Created by andrepapazoglu on 30/11/16.
 */
public class QuantidadeJogadas implements Comparable<QuantidadeJogadas> {
    private Jogada jogada;
    private Long qtd;

    public QuantidadeJogadas() {
    }

    public QuantidadeJogadas(Jogada jogada, Long qtd) {
        this.jogada = jogada;
        this.qtd = qtd;
    }

    public Jogada getJogada() {
        return jogada;
    }

    public void setJogada(Jogada jogada) {
        this.jogada = jogada;
    }

    public Long getQtd() {
        return qtd;
    }

    public void setQtd(Long qtd) {
        this.qtd = qtd;
    }

    @Override
    public int compareTo(QuantidadeJogadas o) {
        int returnComparable = o.qtd.compareTo(this.qtd);


        if(returnComparable == 0) {
            Random random = new Random();

            return (random.nextInt(1 - 0 + 1) + 0) * -1;
        }

        return returnComparable;
    }
}
