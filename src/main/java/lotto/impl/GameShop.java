package lotto.impl;

import lotto.domain.Lotto;
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

    public List<Prize> getResult(List<Lotto> consumerLottos) {
        return lottoGame.getPrizeResults(consumerLottos);
    }

    public void startLottoGame(List<Integer> winningNumbers, int bonusNumber) {
        lottoGame.start(winningNumbers, bonusNumber);
    }
}
