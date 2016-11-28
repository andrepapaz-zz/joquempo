package com.joquempo.repository;

import com.joquempo.entity.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by andrepapazoglu on 22/11/16.
 */
public interface GameRepository extends CrudRepository<Game, Integer> {
    List<Game> findByUserId(Long userId);

    Long countByIdMoveUser(Integer pedra);
}
