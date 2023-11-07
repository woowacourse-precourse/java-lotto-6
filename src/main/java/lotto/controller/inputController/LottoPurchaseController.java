package lotto.controller.inputController;
import lotto.view.inputView.LottoPurchaseInput;

public class LottoPurchaseController {

    private final LottoPurchaseInput inputView = new LottoPurchaseInput();

    public int getPurchaseAmount() {
        while (true) {
            try {
                return inputView.requestPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}