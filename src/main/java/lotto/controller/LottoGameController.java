package lotto.controller;

import lotto.view.InputHandler;
import lotto.view.Printer;

public class LottoGameController {
    public static void startLottoGame() {
        Printer.printPurchaseAmountChoiceMessage();
        InputHandler.getInputMessage();
    }
}
