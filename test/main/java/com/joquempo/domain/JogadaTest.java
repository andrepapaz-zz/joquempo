package main.java.com.joquempo.domain;

import org.junit.Test;

import static org.junit.Assert.*;


public class JogadaTest {

    private void verify(int expected, Jogada usuario, Jogada maquina) {
        JogadaComparator jogadaComparator = new JogadaComparator();

        assertEquals(expected, jogadaComparator.compare(usuario, maquina));
    }

    // Pedra
    @Test
    public void testPedras() {
        Jogada usuario = Jogada.Pedra;
        Jogada maquina = Jogada.Pedra;

        verify(0, usuario, maquina);
    }

    @Test
    public void testPedraVsPapel() {
        Jogada usuario = Jogada.Pedra;
        Jogada maquina = Jogada.Papel;

        verify(-1, usuario, maquina);
    }

    @Test
    public void testPedraVsTesoura() {
        Jogada usuario = Jogada.Pedra;
        Jogada maquina = Jogada.Tesoura;

        verify(1, usuario, maquina);
    }

    // Papel
    @Test
    public void testPapeis() {
        Jogada usuario = Jogada.Papel;
        Jogada maquina = Jogada.Papel;

        verify(0, usuario, maquina);
    }

    @Test
    public void testPapelVsTesoura() {
        Jogada usuario = Jogada.Papel;
        Jogada maquina = Jogada.Tesoura;

        verify(-1, usuario, maquina);
    }

    @Test
    public void testPapelVsPedra() {
        Jogada usuario = Jogada.Papel;
        Jogada maquina = Jogada.Pedra;

        verify(1, usuario, maquina);
    }

    // Tesoura
    @Test
    public void testTesouras() {
        Jogada usuario = Jogada.Tesoura;
        Jogada maquina = Jogada.Tesoura;

        verify(0, usuario, maquina);
    }

    @Test
    public void testTesouraVsPedra() {
        Jogada usuario = Jogada.Tesoura;
        Jogada maquina = Jogada.Pedra;

        verify(-1, usuario, maquina);
    }

    @Test
    public void testTesouraVsPapel() {
        Jogada usuario = Jogada.Tesoura;
        Jogada maquina = Jogada.Papel;

        verify(1, usuario, maquina);
    }

    // Seleciona Vencedor
    @Test
    public void testPedraWinner() {
        Jogada maquinaChoice = Jogada.Pedra;

        JogadaComparator jogadaComparator = new JogadaComparator();

        assertEquals(Jogada.Papel, jogadaComparator.getWinner(maquinaChoice));
    }

    @Test
    public void testTesouraWinner() {
        Jogada maquinaChoice = Jogada.Tesoura;

        JogadaComparator jogadaComparator = new JogadaComparator();

        assertEquals(Jogada.Pedra, jogadaComparator.getWinner(maquinaChoice));
    }

    @Test
    public void testPapelWinner() {
        Jogada maquinaChoice = Jogada.Papel;

        JogadaComparator jogadaComparator = new JogadaComparator();

        assertEquals(Jogada.Tesoura, jogadaComparator.getWinner(maquinaChoice));
    }
}