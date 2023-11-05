package lotto.controller;

import lotto.model.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {
    public void start() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(Integer.parseInt(InputView.readPurchaseAmount()));
    }
}
