package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Unit;
import validator.InputValidator;

public class InputView {

    public static int getPurchaseAmountInput() {
        OutputView.printPurchaseAmountInputMessage();
        while (true) {
            String input = Console.readLine();
            try {
                InputValidator.validatePurchaseAmountInput(input);
                return Integer.parseInt(input) / Unit.PURCHASE_AMOUNT_UNIT.getUnit();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
