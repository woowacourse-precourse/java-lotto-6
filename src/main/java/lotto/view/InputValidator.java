package lotto.view;

import lotto.utils.ErrorMessage;

import static lotto.utils.Parser.parseToInteger;

public class InputValidator {
    private static final Integer PURCHASE_AMOUNT_UNIT = 1000;
    private static final String INTEGER_TYPE_ERROR = "숫자를 입력해주세요.";
    private static final String PURCHASE_AMOUNT_UNIT_ERROR = "구입 금액은 1000원 단위로 입력해주세요.";

    public static void validatePurchaseAmount(String input) {
        validateIntegerType(input);
        validateAmountUnit(parseToInteger(input));
    }

    private static void validateIntegerType(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new ErrorMessage(INTEGER_TYPE_ERROR);
        }
    }

    private static void validateAmountUnit(Integer input) {
        if (input < PURCHASE_AMOUNT_UNIT || input % PURCHASE_AMOUNT_UNIT != 0) {
            throw new ErrorMessage(PURCHASE_AMOUNT_UNIT_ERROR);
        }
    }

}
