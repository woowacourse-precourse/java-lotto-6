package lotto.validator;

import static lotto.validator.ExceptionMessages.NON_NUMERIC_INPUT;

public class Validator {

    public static void validatePurchaseAmount(String input) {
        validateNumericInput(input);
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위로 입력해야 합니다");
        }
    }

    private static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.getErrorMessage());
        }
    }
}