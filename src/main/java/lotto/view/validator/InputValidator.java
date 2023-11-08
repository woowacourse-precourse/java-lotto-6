package lotto.view.validator;

import lotto.util.InputUtil;

import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static lotto.config.GameConfig.*;
import static lotto.exception.ErrorMessage.*;

public class InputValidator {

    private InputValidator() {

    }

    public static void validatePurchaseAmountInput(String input) {
        validateIsEmpty(input);
        validateIsDigit(input);
        validatePurchaseUnit(input);
    }

    private static void validatePurchaseUnit(String input) {
        if (parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(String.format(
                    PURCHASE_UNIT_INVALID.getMessage(),
                    LOTTO_PRICE.getNumber())
            );
        }
    }

    public static void validateBonusNumberInput(String input) {
        validateIsEmpty(input);
        validateIsDigit(input);
        validateLottoNumberRange(input);
    }

    private static void validateIsDigit(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException(INPUT_NOT_DIGIT.getMessage());
        }
    }

    private static boolean isDigit(String input) {
        try {
            parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void validateLottoNumberRange(String input) {
        if (parseInt(input) < 1 || parseInt(input) > 45) {
            throw new IllegalArgumentException(String.format(
                    LOTTO_NUMBER_RANGE_INVALID.getMessage(),
                    MINIMUM_LOTTO_NUMBER.getNumber(),
                    MAXIMUM_LOTTO_NUMBER.getNumber())
            );
        }
    }

    public static void validateLottoNumberInput(String input) {
        validateIsEmpty(input);
        validateIsRightFormat(input);
        List<Integer> lottoNumbers = InputUtil.convertToList(input);
        validateLottoNumbersLength(lottoNumbers);
        validateIsNumberDuplicate(lottoNumbers);
    }

    private static void validateIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_EMPTY.getMessage());
        }
    }

    private static void validateIsRightFormat(String input) {
        if (!isRightFormat(input)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INPUT_INVALID_FORMAT.getMessage());
        }
    }

    private static boolean isRightFormat(String input) {
        String regex = "^(\\d+,)*\\d+$";
        return Pattern.compile(regex)
                .matcher(input)
                .matches();
    }

    private static void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(String.format(
                    LOTTO_NUMBERS_INPUT_LENGTH_INVALID.getMessage(),
                    LOTTO_NUMBERS_LENGTH.getNumber())
            );
        }
    }

    private static void validateIsNumberDuplicate(List<Integer> numbers) {
        if (isNumberDuplicated(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATED.getMessage());
        }
    }

    private static boolean isNumberDuplicated(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }
}
