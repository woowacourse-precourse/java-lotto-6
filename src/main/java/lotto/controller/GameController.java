package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    public void play() {
        OutputView.printGameStartMessage();
        int purchaseInput = InputView.inputPurchaseAmount();
        lottoPurchaseNum(purchaseInput);
    }

    private void lottoPurchaseNum(int lottoNum) {
        OutputView.printLottoPurchaseAmount(lottoNum);
    }
}
