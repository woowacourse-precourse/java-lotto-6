package lotto.game;

import lotto.game.result.AfterLoopResult;
import lotto.game.result.BeforeLoopResult;
import lotto.game.result.GameLoopResult;

public interface Game {
    default void awake() {
    }

    /**
     * executed by {@link GameManager} before each game loop
     *
     * @return : true if start gameLoop()
     */
    default BeforeLoopResult beforeLoop() {
        return BeforeLoopResult.GAME_READY;
    }

    /**
     * @return : true if continue loop
     */
    default GameLoopResult gameLoop() {
        return GameLoopResult.END_GAME;
    }

    /**
     * executed by {@link GameManager} after each game loop
     *
     * @return : true if restart
     */
    default AfterLoopResult afterLoop() {
        return AfterLoopResult.END_GAME;
    }

    default void cleanup() {
    }
}