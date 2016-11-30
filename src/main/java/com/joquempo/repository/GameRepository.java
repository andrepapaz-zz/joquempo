package com.joquempo.repository;

import com.joquempo.entity.Game;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by andrepapazoglu on 22/11/16.
 */
public interface GameRepository extends CrudRepository<Game, Integer> {
    Long countByIdMoveUser(Integer jogada);

    Long countByIdMoveUserAndUserId(Integer jogada, Long userId);
}
