package com.joquempo.controller;

import com.joquempo.domain.MachineChoice;
import com.joquempo.domain.Result;
import com.joquempo.entity.Game;
import com.joquempo.entity.User;
import com.joquempo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by andrepapazoglu on 22/11/16.
 */
@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/machinechoice", method = RequestMethod.GET)
    public MachineChoice getMachineChoice(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");

        MachineChoice machineChoice = gameService.getMachineChoice(user);

        return machineChoice;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Result createGame(@RequestBody Game game, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");

        game.setUser(user);

        return gameService.save(game);
    }

}
