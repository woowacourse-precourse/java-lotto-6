package lotto.controller;

import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public static void run() {
        getPurchaseAmountAndValidate();
    }

    private static int getPurchaseAmountAndValidate() {
        String purchaseAmount = null;

        try {
            OutputView.printInputPurchaseAmount();
            purchaseAmount = InputView.receiveUserInput();
            Validator.validatePurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getPurchaseAmountAndValidate();
        }

        return (Integer.parseInt(purchaseAmount));
    }
}

