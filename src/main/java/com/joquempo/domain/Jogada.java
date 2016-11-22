package main.java.com.joquempo.domain;

/**
 * Created by andrepapazoglu on 20/11/16.
 */
public enum Jogada {
    Pedra(1), Papel(2), Tesoura(3);

    private int id;

    Jogada(int i) {
        this.id = i;
    }

}
