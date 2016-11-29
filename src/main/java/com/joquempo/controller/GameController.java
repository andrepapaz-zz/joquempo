package com.joquempo.controller;

import com.joquempo.domain.MachineChoice;
import com.joquempo.entity.Game;
import com.joquempo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @RequestMapping(value = "/machinechoice", method = RequestMethod.GET)
    public MachineChoice getMachineChoice() {
        MachineChoice machineChoice = gameService.getMachineChoice();

        return machineChoice;
    }

    @RequestMapping(value = "/countStone", method = RequestMethod.GET)
    public Long countAllStone() {
        Long stones = gameService.countAllStone();

        return stones;
    }

    @RequestMapping(value = "/byUser/{userId}", method = RequestMethod.GET)
    public List<Game> listAll(@PathVariable Long userId) {
        List<Game> games = gameService.listAllByUserId(userId);

        return games;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Game game, UriComponentsBuilder ucBuilder) {

        gameService.save(game);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/game/{id}").buildAndExpand(game.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
