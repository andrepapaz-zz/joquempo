package main.java.com.joquempo.domain;

import com.joquempo.domain.Jogada;
import com.joquempo.domain.JogadaComparator;
import org.junit.Test;
import static org.junit.Assert.*;


public class JogadaTest {

    private void verify(int expected, Jogada usuario, Jogada maquina) {
        JogadaComparator jogadaComparator = new JogadaComparator();

        assertEquals(expected, jogadaComparator.compare(usuario, maquina));
    }

    // PEDRA
    @Test
    public void testPedras() {
        Jogada usuario = Jogada.PEDRA;
        Jogada maquina = Jogada.PEDRA;

        verify(0, usuario, maquina);
    }

    @Test
    public void testPedraVsPapel() {
        Jogada usuario = Jogada.PEDRA;
        Jogada maquina = Jogada.PAPEL;

        verify(-1, usuario, maquina);
    }

    @Test
    public void testPedraVsTesoura() {
        Jogada usuario = Jogada.PEDRA;
        Jogada maquina = Jogada.TESOURA;

        verify(1, usuario, maquina);
    }

    // PAPEL
    @Test
    public void testPapeis() {
        Jogada usuario = Jogada.PAPEL;
        Jogada maquina = Jogada.PAPEL;

        verify(0, usuario, maquina);
    }

    @Test
    public void testPapelVsTesoura() {
        Jogada usuario = Jogada.PAPEL;
        Jogada maquina = Jogada.TESOURA;

        verify(-1, usuario, maquina);
    }

    @Test
    public void testPapelVsPedra() {
        Jogada usuario = Jogada.PAPEL;
        Jogada maquina = Jogada.PEDRA;

        verify(1, usuario, maquina);
    }

    // TESOURA
    @Test
    public void testTesouras() {
        Jogada usuario = Jogada.TESOURA;
        Jogada maquina = Jogada.TESOURA;

        verify(0, usuario, maquina);
    }

    @Test
    public void testTesouraVsPedra() {
        Jogada usuario = Jogada.TESOURA;
        Jogada maquina = Jogada.PEDRA;

        verify(-1, usuario, maquina);
    }

    @Test
    public void testTesouraVsPapel() {
        Jogada usuario = Jogada.TESOURA;
        Jogada maquina = Jogada.PAPEL;

        verify(1, usuario, maquina);
    }

    // Seleciona Vencedor
    @Test
    public void testPedraWinner() {
        Jogada maquinaChoice = Jogada.PEDRA;

        JogadaComparator jogadaComparator = new JogadaComparator();

        assertEquals(Jogada.PAPEL, jogadaComparator.getWinner(maquinaChoice));
    }

    @Test
    public void testTesouraWinner() {
        Jogada maquinaChoice = Jogada.TESOURA;

        JogadaComparator jogadaComparator = new JogadaComparator();

        assertEquals(Jogada.PEDRA, jogadaComparator.getWinner(maquinaChoice));
    }

    @Test
    public void testPapelWinner() {
        Jogada maquinaChoice = Jogada.PAPEL;

        JogadaComparator jogadaComparator = new JogadaComparator();

        assertEquals(Jogada.TESOURA, jogadaComparator.getWinner(maquinaChoice));
    }
}