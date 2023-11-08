package lotto.view;

import lotto.utils.ErrorMessage;

import java.util.List;

import static lotto.utils.Parser.*;

public class InputValidator {
    private static final Integer PURCHASE_AMOUNT_UNIT = 1000;
    private static final String COMMA_PATTERN = "^[,\\p{L}\\p{N}\\s]*$";
    private static final String INTEGER_TYPE_ERROR = "숫자를 입력해주세요.";
    private static final String PURCHASE_AMOUNT_UNIT_ERROR = "구입 금액은 1000원 단위로 입력해주세요.";
    private static final String COMMA_ERROR = ",가 아닌 다른 특수문자는 허용하지 않습니다.";
    private static final String LAST_COMMA_ERROR = "입력값 마지막에 ,를 허용하지 않습니다.";

    public static void validatePurchaseAmount(String input) {
        validateIntegerType(input);
        validateAmountUnit(parseToInteger(input));
    }

    public static void validateWinNumbers(String input) {
        validateDivideComma(input);
        validateNumbersIntegerType(input);
    }

    public static void validateBonusNumber(String input) {
        validateIntegerType(input);
    }

    private static void validateDivideComma(String numbers) {
        if (numbers.endsWith(COMMA)) {
            throw new ErrorMessage(LAST_COMMA_ERROR);
        }
        if (!numbers.matches(COMMA_PATTERN)) {
            throw new ErrorMessage(COMMA_ERROR);
        }
    }

    private static void validateNumbersIntegerType(String input) {
        List<String> numbers = parseToStrings(input);
        numbers.stream()
                .forEach(number -> validateIntegerType(number));
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
