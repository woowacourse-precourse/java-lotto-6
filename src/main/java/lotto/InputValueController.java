package lotto;

import java.util.function.Supplier;
import view.InputView;
import java.util.function.Consumer;

public class InputValueController {
    InputView inputView = new InputView();
    InputValidate inputValidate = new InputValidate();

    public void inputPurchaseAmount() {
        inputWithValidation(inputView::purchaseAmount, inputValidate::validatePurchaseAmount);
    }

    public void inputPrizeNumber() {
        inputWithValidation(inputView::prizeNumber, inputValidate::validatePrizeNumber);
    }

    public void inputBonusNumber() {
        inputWithValidation(inputView::bonusNumber, inputValidate::validateBonusNumber);
    }

    private void inputWithValidation(Supplier<String> inputSupplier, Consumer<String> validationFunction) {
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                String input = inputSupplier.get();
                validationFunction.accept(input);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
