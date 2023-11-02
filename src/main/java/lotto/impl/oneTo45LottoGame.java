package lotto.impl;

import lotto.Game;
import lotto.RandomNumberProvider;
import lotto.domain.Lotto;
import lotto.type.GameType;

public class oneTo45LottoGame implements Game {
    private final int LOTTO_ROUND;
    private Lotto lotto;
    private final RandomNumberProvider randomNumberProvider;

    public oneTo45LottoGame(int LOTTO_ROUND, RandomNumberProvider randomNumberProvider1) {
        this.LOTTO_ROUND = LOTTO_ROUND;
        this.randomNumberProvider = randomNumberProvider1;
    }

    @Override
    public void start() {
        initThisRound();
    }

    @Override
    public boolean supports(GameType gameType) {
        return gameType == GameType.ONE_TO_FORTYFIVE_LOTTO_GAME;
    }

    private void initThisRound() {
        lotto = new Lotto(randomNumberProvider.generateRandomNumber());
    }
}
