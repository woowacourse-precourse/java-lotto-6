package lotto.game;

import lotto.exceptions.GameNullPointerException;
import lotto.game.result.AfterLoopResult;
import lotto.game.result.BeforeLoopResult;
import lotto.game.result.GameLoopResult;

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
        if (game.beforeLoop() == BeforeLoopResult.GAME_NOT_READY) {
            return false;
        }

        boolean continueGame = true;
        while (continueGame) {
            continueGame = game.gameLoop() == GameLoopResult.CONTINUE_GAME;
        }
        return game.afterLoop() == AfterLoopResult.RESTART_GAME;
    }
}