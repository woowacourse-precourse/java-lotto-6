package lotto.controller.inputCreator;

import lotto.domain.PurchaseAmount;
import lotto.view.InputPurchaseAmountView;

public class PurchaseAmountController implements ObjectCreator<PurchaseAmount, String> {
    @Override
    public PurchaseAmount createObjectByInput(String x) {
        int purchaseAmount =  InputPurchaseAmountView.inputPurchaseAmount();
        return new PurchaseAmount(purchaseAmount);
    }
}
