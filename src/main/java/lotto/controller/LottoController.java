package lotto.controller;

import lotto.model.PurchaseAmount;
import lotto.util.Parser;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(readPurchaseAmount());
    }

    private int readPurchaseAmount() {
        return Parser.parseToInt(InputView.readPurchaseAmount());
    }
}
