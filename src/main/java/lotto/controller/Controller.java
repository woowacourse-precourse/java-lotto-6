package lotto.controller;

import lotto.view.BuyLottoInput;
import lotto.view.LottosOutput;
import lotto.view.BonusWinningInput;

public class Controller {

    public static void Run() {
        int tickets = BuyLottoInput.buyLottoInput();
        LottosOutput.lottosOutput(tickets);
        BonusWinningInput.bonusWinningInput();
    }

}