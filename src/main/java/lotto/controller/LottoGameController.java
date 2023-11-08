package lotto.controller;

public class LottoGameController {
    private LottoPurchaseController lottoPurchaseController;
    private LottoWinningCalculationController lottoWinningCalculationController;

    public LottoGameController() {
        lottoPurchaseController = new LottoPurchaseController();
        lottoWinningCalculationController = new LottoWinningCalculationController();
    }

    public void start() {
        lottoPurchaseController.purchaseLottos();
    }
}
