package lotto.controller.inputController;
import lotto.view.inputView.LottoPurchaseInput;

public class PurchaseController {

    private final LottoPurchaseInput inputView = new LottoPurchaseInput();

    public int getPurchaseAmount() {
        return inputView.requestPurchaseAmount();
    }
}