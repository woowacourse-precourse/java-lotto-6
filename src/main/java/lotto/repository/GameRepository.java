package lotto.repository;

import lotto.domain.Game;

import java.util.HashMap;
import java.util.Map;

public class GameRepository {

    private Long id = 0L;
    private final Map<Long, Game> games = new HashMap<>();


    public Long save(Game game){
        games.put(id,game);
        id += 1;
        return id;
    }


}
