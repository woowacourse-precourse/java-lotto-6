package lotto.Validator;

import static lotto.config.ErrorMessage.INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE;
import static lotto.config.ErrorMessage.INPUT_AMOUNT_DIVISION_ERROR_MESSAGE;

/**
 * 사용자가 입력한 구입 금액 입력값 검사
 */
public class PurchaseAmountValidator extends Validator<String> {
    @Override
    public String valid(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE.getMessage());
        }
        if (!isDivisibleByThousand(input)) {
            throw new IllegalArgumentException(INPUT_AMOUNT_DIVISION_ERROR_MESSAGE.getMessage());
        }
        return input;
    }

    private boolean isDivisibleByThousand(String input) {
        return toInteger(input) % 1000 == 0;
    }

    private int toInteger(String input) {
        return Integer.parseInt(input);
    }
}
