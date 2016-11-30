package com.joquempo.service;

import com.joquempo.domain.Jogada;
import com.joquempo.domain.JogadaComparator;
import com.joquempo.domain.MachineChoice;
import com.joquempo.entity.Game;
import com.joquempo.entity.User;
import com.joquempo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by andrepapazoglu on 22/11/16.
 */
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> listAll() {
        List<Game> all = (List<Game>) gameRepository.findAll();

        return all;
    }

    public String save(Game game) {
        gameRepository.save(game);

        Jogada jogadaUser = Jogada.getValue(game.getIdMoveUser());
        Jogada jogadaMachine = Jogada.getValue(game.getIdMoveMachine());

        JogadaComparator jogadaComparator = new JogadaComparator();

        int compare = jogadaComparator.compare(jogadaUser, jogadaMachine);
        String message = "Você Empatou! Mas já nos ajudou colaborando!";
        if (compare < 0) {
            message = "Que Pena, você Perdeu! Mas pelo menos você Colaborou!";
        } else if (compare > 0) {
            message = "Parabéns Você ganhou! E Colaborou também!";
        }

        return message;
    }

    public Long countAllStone() {
        return gameRepository.countByIdMoveUser(Jogada.PEDRA.getId());
    }

    public MachineChoice getMachineChoice(User user) {
        Long qtdPedras = gameRepository.countByIdMoveUser(Jogada.PEDRA.getId());
        Long qtdPapeis = gameRepository.countByIdMoveUser(Jogada.PAPEL.getId());
        Long qtdTesouras = gameRepository.countByIdMoveUser(Jogada.TESOURA.getId());

        Long qtdUserPedras = gameRepository.countByIdMoveUserAndUserId(Jogada.PEDRA.getId(), user.getId());
        Long qtdUserPapeis = gameRepository.countByIdMoveUserAndUserId(Jogada.PAPEL.getId(), user.getId());
        Long qtdUserTesouras = gameRepository.countByIdMoveUserAndUserId(Jogada.TESOURA.getId(), user.getId());

        TreeMap<Long, Integer> mapAll = new TreeMap<Long, Integer>();
        mapAll.put(qtdPedras, Jogada.PEDRA.getId());
        mapAll.put(qtdPapeis, Jogada.PAPEL.getId());
        mapAll.put(qtdTesouras, Jogada.TESOURA.getId());

        mapAll.put(qtdUserPedras, Jogada.PEDRA.getId());
        mapAll.put(qtdUserPapeis, Jogada.PAPEL.getId());
        mapAll.put(qtdUserTesouras, Jogada.TESOURA.getId());

        Jogada maisJogada;

        if (mapAll.size() <= 2) {
            Random rn = new Random();
            int i = rn.nextInt(3 - 1 + 1) + 1;
            maisJogada = Jogada.getValue(i);
        } else {
            Random rnfilter = new Random();
            int ifilter = rnfilter.nextInt(1 - 0 + 1) + 0;
            if (mapAll.size() == 1) {
                maisJogada = Jogada.getValue(mapAll.get(mapAll.lastKey()));
            } else {
                maisJogada = Jogada.getValue(mapAll.get(mapAll.lastKey() - ifilter));
            }
        }

        JogadaComparator jogadaComparator = new JogadaComparator();

        Jogada winner = jogadaComparator.getWinner(maisJogada);

        MachineChoice machineChoice = new MachineChoice();

        machineChoice.setChoice(winner.getId());

        return machineChoice;

    }
}
