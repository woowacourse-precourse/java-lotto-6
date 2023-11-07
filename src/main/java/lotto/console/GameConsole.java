package lotto.console;

import lotto.console.game.Game;
import lotto.console.game.lotto.LottoGame;

import java.util.ArrayList;
import java.util.List;

public class GameConsole {

    private List<Game> games;

    public GameConsole() {
        init();
    }

    private void init() {
        games = new ArrayList<>();
        addGame(new LottoGame());
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void start() {
        System.out.println("콘솔 스타뜨");
        games.forEach(Game::start);
        System.out.println("콘솔 끝");
    }
}

