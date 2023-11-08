package lotto.controller;

import lotto.model.LottoBuyer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        OutputView.printBuyLottoPromptMessage();
        int buyAmount = InputView.readLottoBuyAmount();
        LottoBuyer lottoBuyer = new LottoBuyer(buyAmount);
    }

}
