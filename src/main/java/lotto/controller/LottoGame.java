package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.utils.InputUtil;
import lotto.utils.LottoUtils;
import lotto.validation.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private static final int LOTTO_PRISE = 1000;
    private static final int PERCENT = 100;
    private final LottoService lottoService = new LottoService();
    private final HashMap<Rank, Integer> result = new HashMap<>();
    private Buyer buyer;
    private WinningLotto winningLotto;
    private long reward;
    public void run() {
        buyLotto();
        initWinningLotto();
        initResult();
        matchLottos();
        showResult();
    }

    private void initWinningLotto() {
        winningLotto = lottoService.initWinningLotto();
    }

    private void buyLotto() {
        InputView.inputPrise();
        buyer = lottoService.purchaseLotto();
        buyer.showLottos();
    }

    private void matchLottos() {
        for (Lotto lotto : buyer.getLottos()) {
            int cnt = LottoUtils.matchLotto(lotto.getNumbers(), winningLotto.getNumbers());
            boolean bonusMatch = LottoUtils.matchBonus(cnt, lotto, winningLotto.getBonus());
            calcPrize(cnt, bonusMatch);
        }
    }

    private void calcPrize(int cnt, boolean bonus) {
        Rank rank = Rank.getPrize(cnt, bonus);
        result.put(rank, result.get(rank) + 1);
        reward = rank.calculateReward(reward);
    }

    private void initResult() {
        reward = 0;
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    private void showResult() {
        OutputView.showResult(result);
        OutputView.showRateOfReturn(((double) reward / getAmount()) * PERCENT);
    }

    private long getAmount() {
        return (long) buyer.getLottos().size() * LOTTO_PRISE;
    }
}
