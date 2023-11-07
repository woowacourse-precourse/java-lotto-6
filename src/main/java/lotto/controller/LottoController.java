package lotto.controller;

import lotto.model.PurchasePrice;
import lotto.view.InputView;

public class LottoController {
    PurchasePrice purchasePrice;
    public void setPurchasePrice() {
        purchasePrice = new PurchasePrice(InputView.inputPrice());
    }
}
