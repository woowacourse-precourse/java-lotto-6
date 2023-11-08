package lotto.controller;

import lotto.model.Lottos;

public class LottoGameController {
    private LottoPurchaseController lottoPurchaseController;
    private LottoWinningCalculationController lottoWinningCalculationController;

    public LottoGameController() {
        lottoPurchaseController = new LottoPurchaseController();
        lottoWinningCalculationController = new LottoWinningCalculationController();
    }

    public void start() {
        Lottos lottos = lottoPurchaseController.purchaseLottos();
        lottoWinningCalculationController.calculateWinningStatistics(lottos);
    }
}
