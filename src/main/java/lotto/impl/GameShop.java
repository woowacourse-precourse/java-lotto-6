package lotto.impl;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.type.Prize;

import java.util.List;

public class GameShop {
    private final LottoGame lottoGame;

    public GameShop(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public List<Lotto> purchase(int amount) {
        return lottoGame.purchase(amount);
    }

    public List<Prize> getResults(List<Lotto> consumerLottos) {
        return lottoGame.getPrizeResults(consumerLottos);
    }

    public Prize getResult(Lotto consumerLotto) {
        return lottoGame.getPrizeResult(consumerLotto);
    }

    public void startLottoGame(WinningLotto winningLotto) {
        lottoGame.start(winningLotto);
    }
}
