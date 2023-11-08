package validate;

import java.util.Arrays;
import java.util.List;

import static constants.LottoErrorMessageConstants.*;

public class InputValidation {
    public static void validateNumericInput(String input) {
        if (!input.matches("^[0-9]+$")){
            throw new IllegalArgumentException(ERROR_MESSAGE_NON_NUMERIC_VALUE);
        }
    }

    public static void validateNonZeroInput(String input) {
        if(input.equals("0")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ZERO_NOT_ALLOWED);
        }
    }

    public static void validateLottoNumberCount(List<Integer> list) {
        if (list.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    public static void validateLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_LOTTO_NUMBER);
        }
    }

    public static void validateNoDuplicateNumbers(List<Integer> list, int number) {
        if (list.contains(number)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_NUMBER);
        }
    }

    public static void validateNoDuplicateNumbers(List<Integer> list) {
        if (list.stream().distinct().count() != list.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_NUMBER);
        }
    }

    public static void validateAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DIVISION_REMAINDER);
        }
    }
}
