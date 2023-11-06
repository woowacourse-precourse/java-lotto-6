package lotto.domain;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;
import lotto.ui.Input;

public class InputValidation {
    public static int validateNumber(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER.getMessage());
        }
        return result;
    }

    public static void checkDivisible(int amount) {
        if (amount % LottoNumber.PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE.getMessage());
        }
    }

    public static void checkSufficient(int amount) {
        if (amount < LottoNumber.PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT.getMessage());
        }
    }

    public static void checkDelimiter(String input) {
        if (input.isEmpty() || input.charAt(input.length() - 1) == Input.DELIMITER) {
            throw new IllegalArgumentException(ErrorMessage.DELIMITER.getMessage());
        }
    }

    public static void checkOverlap(int number, Lotto winningNumber) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.OVERLAP.getMessage());
        }
    }

    public static void checkRange(int number) {
        if (number < LottoNumber.MINIMUM.getValue() || number > LottoNumber.MAXIMUM.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.RANGE.getMessage());
        }
    }
}
