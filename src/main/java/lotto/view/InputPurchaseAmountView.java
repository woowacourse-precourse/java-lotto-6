package lotto.view;

import static lotto.config.GameNumberConfig.LOTTO_PRICE;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_EMPTY;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_NUMBER;
import static lotto.exception.ErrorMessage.VALIDATE_PURCHASE_AMOUNT_DIVIDE;
import static lotto.view.constants.OutputMessage.INPUT_PURCHASE_AMOUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputPurchaseAmountView {
    private InputPurchaseAmountView() {
    }

    public static int inputPurchaseAmount() {
        OutputView.printMessage(INPUT_PURCHASE_AMOUNT_MESSAGE.getMessage());

        String input = Console.readLine();
        validatePurchaseAmount(input);
        return parsePurchaseAmount(input);
    }

    private static void validatePurchaseAmount(String input) {
        checkEmpty(input);
        checkDivide(input);
    }

    private static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(VALIDATE_INPUT_EMPTY.getMessage());
        }
    }

    private static void checkDivide(String input) {
        int price = parseInt(input);
        if (price % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(VALIDATE_PURCHASE_AMOUNT_DIVIDE.getMessage());
        }
    }

    private static int parsePurchaseAmount(String input) {
        int price = parseInt(input);
        return price;
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_INPUT_NUMBER.getMessage());
        }
    }
}
