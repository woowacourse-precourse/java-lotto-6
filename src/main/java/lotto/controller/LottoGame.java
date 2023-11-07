package lotto.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.utils.LottoUtils;
import lotto.view.OutputView;

public class LottoGame {
    private static final String DECIMAL_FORMAT = "###,##0.0";
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
        buyer = lottoService.purchaseLotto();
        buyer.showLottos();
    }

    private void matchLottos() {
        for (Lotto lotto : buyer.getLottos()) {
            Rank rank = lottoService.getRankCode(lotto, winningLotto);
            calcPrize(rank);
        }
    }

    private void calcPrize(Rank rank) {
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
        OutputView.showRateOfReturn(returnRate());
    }

    private String returnRate() {
        DecimalFormat decFormat = new DecimalFormat(DECIMAL_FORMAT);
        return decFormat.format(((double) reward / getAmount()) * PERCENT);
    }

    private long getAmount() {
        return (long) buyer.getLottos().size() * LOTTO_PRISE;
    }
}
