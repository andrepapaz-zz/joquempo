package main.java.com.joquempo.domain;

import java.util.Comparator;

/**
 * Created by andrepapazoglu on 20/11/16.
 */
public class JogadaComparator implements Comparator<Jogada> {

    @Override
    public int compare(Jogada o1, Jogada o2) {

        if (o1.equals(Jogada.Pedra) && o2.equals(Jogada.Papel)) return -1;

        if (o1.equals(Jogada.Pedra) && o2.equals(Jogada.Tesoura)) return 1;

        if (o1.equals(Jogada.Papel) && o2.equals(Jogada.Tesoura)) return -1;

        if (o1.equals(Jogada.Papel) && o2.equals(Jogada.Pedra)) return 1;

        if (o1.equals(Jogada.Tesoura) && o2.equals(Jogada.Pedra)) return -1;

        if (o1.equals(Jogada.Tesoura) && o2.equals(Jogada.Papel)) return 1;

        return 0;
    }

    public Jogada getWinner(Jogada maquinaChoice) {

        Jogada[] values = Jogada.values();

        for (Jogada value : values) {

            if (this.compare(value, maquinaChoice) == 1) return value;

        }

        return null;
    }
}
