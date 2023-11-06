package lotto.controller.inputController;
import lotto.view.inputView.LottoPurchaseInput;

public class LottoPurchaseController {

    private final LottoPurchaseInput inputView = new LottoPurchaseInput();

    public int getPurchaseAmount() {
        return inputView.requestPurchaseAmount();
    }
}