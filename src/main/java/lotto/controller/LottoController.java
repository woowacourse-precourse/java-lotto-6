package lotto.controller;

import lotto.domain.LottoCost;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        LottoCost lottoCost = getLottoCost();
        int lottoCount = lottoCost.getLottoCount();
    }

    private LottoCost getLottoCost() {
        return new LottoCost(InputView.totalCost());
    }
}
