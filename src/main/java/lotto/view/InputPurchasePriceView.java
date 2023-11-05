package lotto.view;

import static lotto.config.GameNumberConfig.LOTTO_PRICE;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_EMPTY;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_NUMBER;
import static lotto.exception.ErrorMessage.VALIDATE_PURCHASE_PRICE_DIVIDE;
import static lotto.view.constants.OutputMessage.INPUT_PURCHASE_PRICE_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputPurchasePriceView {
    private InputPurchasePriceView() {
    }

    public static int inputPurchasePrice() {
        OutputView.printMessage(INPUT_PURCHASE_PRICE_MESSAGE.getMessage());

        String input = Console.readLine();
        validatePurchasePrice(input);
        return parsePurchasePrice(input);
    }

    private static void validatePurchasePrice(String input) {
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
        if (price % LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(VALIDATE_PURCHASE_PRICE_DIVIDE.getMessage());
        }
    }

    private static int parsePurchasePrice(String input) {
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
