package lotto;

import lotto.exceptions.GameNullPointerException;

public class GameManager {
    private final Game game;

    public GameManager(Game game) {
        if (game == null) {
            throw new GameNullPointerException();
        }
        this.game = game;
    }

    public void start() {
        boolean startGame = true;

        game.awake();
        while (startGame) {
            startGame = inGameLoop();
        }
        game.cleanup();
    }

    private boolean inGameLoop() {
        if (!game.beforeLoop()) {
            return false;
        }

        boolean continueGame = true;
        while (continueGame) {
            continueGame = game.gameLoop();
        }
        return game.afterLoop();
    }
}