package com.joquempo.service;

import com.joquempo.domain.Jogada;
import com.joquempo.entity.Game;
import com.joquempo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void save(Game game) {
        gameRepository.save(game);
    }

    public List<Game> listAllByUserId(Long userId) {
        List<Game> games = gameRepository.findByUserId(userId);

        return games;

    }

    public Long countAllStone() {
        return gameRepository.countByIdMoveUser(Jogada.PEDRA.getId());
    }
}
