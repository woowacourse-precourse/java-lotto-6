package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class controller {

    public void run(){
        PurchaseAmount purchaseAmount = getPurchaseAmount();
    }

    private PurchaseAmount getPurchaseAmount() {
        try {
            return PurchaseAmount.of(Parser.parseToInt(InputView.getPurchaseAmountInput()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getPurchaseAmount();
        }
    }
}


