package lotto.controller.inputController;
import lotto.view.inputView.LottoPurchaseInput;

public class LottoPurchaseController {
    private final LottoPurchaseInput inputView;

    public LottoPurchaseController(LottoPurchaseInput inputView) {
        this.inputView = inputView;
    }

    public String requestPurchaseAmount() {
        while (true) {
            try {
                return inputView.requestPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}