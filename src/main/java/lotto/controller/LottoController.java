package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        OutputView.printBuyLottoPromptMessage();
        InputView.readLottoBuyAmount();
    }

}
