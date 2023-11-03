package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public static void run() {

    }

    private static int getPurchaseAmountAndValidate() {
        OutputView.printInputPurchaseAmount();
        String PurchaseAmount = InputView.receiveUserInput();

        return (Integer.parseInt(PurchaseAmount));
    }
}
