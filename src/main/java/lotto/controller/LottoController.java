package lotto.controller;

import lotto.model.BuyInfo;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        OutputView.printBuyLottoPromptMessage();
        BuyInfo buyInfo = InputView.readLottoBuyAmount();
    }

}
