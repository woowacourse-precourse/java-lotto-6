package lotto.controller;

import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private PurchaseAmountService purchaseAmountService;
    private LottoService lottoService;
    private WinningNumberService winningNumberService;
    private StaticService staticService;

    public LottoGameController( ) {
        this.purchaseAmountService = new PurchaseAmountService();
        this.lottoService = new LottoService();
        this.winningNumberService = new WinningNumberService();
        this.staticService = new StaticService();
    }

    public void purchase() {
        InputView.inputPurchaseAmount();
        purchaseAmountService.makePurchaseAmount();
        OutputView.outputBlank();
    }

    public void showLottos() {
        int purchaseAmount = purchaseAmountService.getPurchaseAmount();
        int count = lottoService.setLottoCount(purchaseAmount);
        OutputView.outputLottoCount(count);
        lottoService.makeRandomLottos(count);
        lottoService.outputLottos();
        OutputView.outputBlank();
    }

    public void pickWinningNumber() {
        InputView.inputWinningNumber();
        Lotto lotto = lottoService.makeWinningLotto();
        OutputView.outputBlank();

        InputView.inputBonusNumber();
        int bonusNumber = winningNumberService.makeBonusNumber();
        OutputView.outputBlank();
        winningNumberService.makeWinningNumber(lotto, bonusNumber);
    }

    public void winningStatistics() {
        OutputView.outputWinningStatistics();
        staticService.makeStatistics();
        staticService.setStatics(lottoService.getLottos(),winningNumberService.getWinningLotto(), winningNumberService.getBonusNumber());
        staticService.outputStatistics();
        staticService.makeRate(purchaseAmountService.getPurchaseAmount());
        staticService.outputRate();
    }
}
