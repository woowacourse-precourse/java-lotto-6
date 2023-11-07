package lotto;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import model.InputValueValidation;
import view.InputView;

public class InputValueController {
    private final InputView inputView;
    private final InputValueValidation inputValueValidation;

    public InputValueController(InputView inputView, InputValueValidation inputValueValidation) {
        this.inputView = inputView;
        this.inputValueValidation = inputValueValidation;
    }

    public int inputPurchaseAmount() {
        return getInput(
                inputView::purchaseAmount,
                inputValueValidation::validatePurchaseAmount
        );
    }

    public List<Integer> inputPrizeNumber() {
        return getInput(
                inputView::prizeNumber,
                inputValueValidation::validatePrizeNumber
        );
    }

    public int inputBonusNumber(List<Integer> prizeNumber) {
        return getInput(
                inputView::bonusNumber,
                enteredBonusNumber -> inputValueValidation.validateBonusNumber(prizeNumber, enteredBonusNumber)
        );
    }

    private <T> T getInput(Supplier<String> inputSupplier, Function<String, T> validationFunction) {
        while (true) {
            try {
                String input = inputSupplier.get();
                return validationFunction.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
