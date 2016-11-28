package com.joquempo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @NotNull
    private Integer idMoveUser;

    @NotNull
    private Integer idMoveMachine;

    @Transient
    @JsonIgnore
    private Jogada userChoice;

    @Transient
    @JsonIgnore
    private Jogada machineChoice;

    public Game() {
    }

    public Game(User user, Integer idMoveUser, Integer idMoveMachine) {
        this.user = user;
        this.idMoveUser = idMoveUser;
        this.idMoveMachine = idMoveMachine;
    }

    public Game(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
