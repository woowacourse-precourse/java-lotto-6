package lotto.validator;

public class InputValidator {
    public static final String WRONG_INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액은 숫자로 입력해주세요.";

    public void validatePurchaseAmount(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(WRONG_INPUT_PURCHASE_AMOUNT_MESSAGE);
        }
    }
}
