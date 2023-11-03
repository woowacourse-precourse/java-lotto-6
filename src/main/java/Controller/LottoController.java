package Controller;

import Model.PurchaseAmount;
import view.InputView;

public class LottoController {
    private PurchaseAmount purchaseAmount;

    public void buyMyLotto() {
        int inputPurchaseAmount = InputView.getPurchaseAmount();
        purchaseAmount = new PurchaseAmount(inputPurchaseAmount);
    }
}
