package lotto.impl;

import lotto.Game;
import lotto.type.GameType;

public class oneTo45LottoGame implements Game {
    @Override
    public void start() {

    }

    @Override
    public boolean supports(GameType gameType) {
        return gameType == GameType.ONE_TO_FORTYFIVE_LOTTO_GAME;
    }
}
