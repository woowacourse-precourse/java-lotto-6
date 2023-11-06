package lotto;

import lotto.game.result.AfterLoopResult;
import lotto.game.result.BeforeLoopResult;
import lotto.game.Game;
import lotto.game.result.GameLoopResult;
import lotto.io.Output;

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
