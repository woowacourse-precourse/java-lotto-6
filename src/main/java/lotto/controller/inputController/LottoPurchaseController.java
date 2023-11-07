package lotto.controller.inputController;
import lotto.model.validator.FirstInputValidator;
import lotto.view.inputView.LottoPurchaseInput;

public class LottoPurchaseController {


    private final LottoPurchaseInput inputView = new LottoPurchaseInput();

    public int getPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.requestPurchaseAmount();
                return FirstInputValidator.validatePurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}