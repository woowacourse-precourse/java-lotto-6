package lotto.controller;

import lotto.view.BuyLottoInput;
import lotto.view.LottosOutput;

public class Controller {

    public static void Run() {
        int tickets = BuyLottoInput.buyLottoInput();
        LottosOutput.lottosOutput(tickets);
    }

}