package lotto.Validator;

import static lotto.config.ErrorMessage.INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE;

/**
 * 사용자가 입력한 구입 금액 입력값 검사
 */
public class PurchaseAmountValidator extends Validator<String> {
    @Override
    public String valid(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(INPUT_AMOUNT_CHARACTER_ERROR_MESSAGE.getMessage());
        }
        return input;
    }
}
