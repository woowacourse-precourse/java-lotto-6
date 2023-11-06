package lotto;

import lotto.game.AfterLoopResult;
import lotto.game.BeforeLoopResult;
import lotto.game.Game;
import lotto.game.GameLoopResult;

public class LottoGame implements Game {
    @Override
    public BeforeLoopResult beforeLoop() {
        return BeforeLoopResult.GAME_READY;
    }

    @Override
    public GameLoopResult gameLoop() {
        return GameLoopResult.END_GAME;
    }

    @Override
    public AfterLoopResult afterLoop() {
        return AfterLoopResult.END_GAME;
    }
}
