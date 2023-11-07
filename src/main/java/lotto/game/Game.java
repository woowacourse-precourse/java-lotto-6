package lotto.game;

import lotto.game.result.AfterLoopResult;
import lotto.game.result.BeforeLoopResult;
import lotto.game.result.GameLoopResult;

public interface Game {
    default void awake() {
    }

    default BeforeLoopResult beforeLoop() {
        return BeforeLoopResult.GAME_READY;
    }

    default GameLoopResult gameLoop() {
        return GameLoopResult.END_GAME;
    }

    default AfterLoopResult afterLoop() {
        return AfterLoopResult.END_GAME;
    }

    default void cleanup() {
    }
}