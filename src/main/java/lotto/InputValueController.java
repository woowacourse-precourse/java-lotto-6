package lotto;

import java.util.function.Supplier;
import util.InputValueValidation;
import view.InputView;
import java.util.function.Consumer;

public class InputValueController {
    InputView inputView = new InputView();
    InputValueValidation inputValueValidation = new InputValueValidation();

    public void inputPurchaseAmount() {
        inputWithValidation(inputView::purchaseAmount, inputValueValidation::validatePurchaseAmount);
    }

    public void inputPrizeNumber() {
        inputWithValidation(inputView::prizeNumber, inputValueValidation::validatePrizeNumber);
    }

    public void inputBonusNumber() {
        inputWithValidation(inputView::bonusNumber, inputValueValidation::validateBonusNumber);
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
