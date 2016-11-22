package com.joquempo.entity;

import com.joquempo.domain.Jogada;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by andrepapazoglu on 22/11/16.
 */
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column
    private Integer idMoveUser;

    @NotNull
    @Column
    private Integer idMoveMachine;

    @Transient
    private Jogada userChoice;

    @Transient
    private Jogada machineChoice;

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdMoveUser() {
        return idMoveUser;
    }

    public void setIdMoveUser(Integer idMoveUser) {
        this.idMoveUser = idMoveUser;
    }

    public Integer getIdMoveMachine() {
        return idMoveMachine;
    }

    public void setIdMoveMachine(Integer idMoveMachine) {
        this.idMoveMachine = idMoveMachine;
    }

    public Jogada getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(Jogada userChoice) {
        this.userChoice = userChoice;
    }

    public Jogada getMachineChoice() {
        return machineChoice;
    }

    public void setMachineChoice(Jogada machineChoice) {
        this.machineChoice = machineChoice;
    }
}
