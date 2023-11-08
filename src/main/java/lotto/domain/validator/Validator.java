package lotto.domain.validator;

import lotto.constant.PatternConstant;
import lotto.constant.RegularConstant;
import lotto.constant.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

public final class Validator {

    private Validator() {
    }

    public static void validateExistValue(String inputValue) {
        String val = inputValue.trim();
        if (val.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NON_EXISTENT_VALUE);
        }
    }

    public static int validateNumericInput(String inputValue) {
        Matcher matcher = PatternConstant.NUMBER_PATTERN.matcher(inputValue);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMERIC_VALUE);
        }

        return Integer.parseInt(inputValue);
    }

    public static void validateDivisibleBy1000(int inputMoney) {
        if (inputMoney % RegularConstant.UNIT_AMOUNT != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INDIVISIBLE_BY_1000);
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        boolean hasDuplicates = false;
        Set<Integer> duplicateChecker = new HashSet<>();

        for (Integer number : numbers) {
            if (!duplicateChecker.add(number)) {
                hasDuplicates = true;
                break;
            }
        }

        if (hasDuplicates) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_HAS_DUPLICATE_NUMBERS);
        }
    }

    public static String[] hasCommasWithoutSurroundingValues(String valuesSeparatedByCommas) {
        Matcher matcher = PatternConstant.HAS_COMMAS_WITHOUT_SURROUNDING_VALUES_PATTERNS.matcher(valuesSeparatedByCommas);

        if (matcher.find())
            throw new IllegalArgumentException(ErrorMessage.ERROR_CONTAIN_CONSECUTIVE_COMMAS);

        return valuesSeparatedByCommas.split(RegularConstant.DELIMITER);
    }

    public static void validateCountOfValues(String[] splitValues) {
        if (splitValues.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_COUNT_OF_VALUES);
        }
    }

    public static void validateCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_COUNT_OF_VALUES);
        }
    }

    public static int validateNumberInRange(int num) {
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_OF_RANGES);
        }

        return num;
    }

}
