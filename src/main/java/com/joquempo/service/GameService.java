package com.joquempo.service;

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

}
