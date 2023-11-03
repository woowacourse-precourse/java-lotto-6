package lotto.impl;

import lotto.domain.Lotto;

import java.util.List;

public class GameShop {
    private final LottoGame lottoGame;

    public GameShop(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public List<Lotto> purchase(int amount) {
        return lottoGame.purchase(amount);
    }
}
