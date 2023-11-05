package lotto.model;

import static lotto.views.MessageManager.*;

public class InputValidator {
    public static void validateNonInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(getValidateNonIntegerMessage());
        }
    }

    public static void validateDivisibleByThousand(int input) {
        if ( input % 1000 != 0) {
            throw new IllegalArgumentException("입력된 숫자가 1000으로 나누어 떨어지지 않습니다.");
        }
    }
}
