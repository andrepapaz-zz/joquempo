package com.joquempo.service;

import com.joquempo.domain.*;
import com.joquempo.entity.Game;
import com.joquempo.entity.User;
import com.joquempo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Result save(Game game) {
        gameRepository.save(game);

        Jogada jogadaUser = Jogada.getValue(game.getIdMoveUser());
        Jogada jogadaMachine = Jogada.getValue(game.getIdMoveMachine());

        JogadaComparator jogadaComparator = new JogadaComparator();

        Result result = new Result();

        int compare = jogadaComparator.compare(jogadaUser, jogadaMachine);
        result.setResult("Você Empatou! Mas já nos ajudou colaborando!");
        if (compare < 0) {
            result.setResult("Que Pena, você Perdeu! Mas pelo menos você Colaborou!");
        } else if (compare > 0) {
            result.setResult("Parabéns Você ganhou! E Colaborou também!");
        }

        result.setValor(compare);

        return result;
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

        List<QuantidadeJogadas> quantidadeJogadasList = new ArrayList<QuantidadeJogadas>();

        quantidadeJogadasList.add(new QuantidadeJogadas(Jogada.PEDRA, qtdPedras));
        quantidadeJogadasList.add(new QuantidadeJogadas(Jogada.PAPEL, qtdPapeis));
        quantidadeJogadasList.add(new QuantidadeJogadas(Jogada.TESOURA, qtdTesouras));

        Collections.sort(quantidadeJogadasList);

        List<QuantidadeJogadas> quantidadeUserJogadasList = new ArrayList<QuantidadeJogadas>();

        quantidadeUserJogadasList.add(new QuantidadeJogadas(Jogada.PEDRA, qtdUserPedras));
        quantidadeUserJogadasList.add(new QuantidadeJogadas(Jogada.PAPEL, qtdUserPapeis));
        quantidadeUserJogadasList.add(new QuantidadeJogadas(Jogada.TESOURA, qtdUserTesouras));

        Collections.sort(quantidadeUserJogadasList);

        Jogada maisJogada;

        Random rnd = new Random();

        int rndi = rnd.nextInt(1 - 0 + 1) + 0;

        if (quantidadeJogadasList.get(rndi).getJogada() == quantidadeUserJogadasList.get(rndi).getJogada()) {
            maisJogada = quantidadeJogadasList.get(rndi).getJogada();
        } else {
            Random random = new Random();

            int i = random.nextInt(1 - 0 + 1) + 0;

            maisJogada = i == 1 ? quantidadeJogadasList.get(i).getJogada() : quantidadeUserJogadasList.get(i).getJogada();
        }


        JogadaComparator jogadaComparator = new JogadaComparator();

        Jogada winner = jogadaComparator.getWinner(maisJogada);

        MachineChoice machineChoice = new MachineChoice();

        machineChoice.setChoice(winner.getId());

        return machineChoice;

    }
}
