package com.joquempo.controller;

import com.joquempo.entity.Game;
import com.joquempo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by andrepapazoglu on 22/11/16.
 */
@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Game> listAll() {
        List<Game> games = gameService.listAll();

        return games;
    }
}
