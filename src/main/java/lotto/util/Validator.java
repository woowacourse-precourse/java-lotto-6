package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    public static int isValidPurchaseAmount(String input) {
        isEmpty(input);
        isNumeric(input);
        isThousandUnit(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> isValidWinningNumbers(String input) {
        isEmpty(input);
        isValidCommaSeparator(input);
        String[] numbers = input.split(Constants.COMMA);
        isSixItems(numbers);
        isDuplicateWinNumber(numbers);
        for (String number : numbers) {
            isNumeric(number);
            isNumberInRange(number);
        }
        return convertToList(numbers);
    }

    public static int isValidBonusNumber(String input) {
        isEmpty(input);
        isNumeric(input);
        isNumberInRange(input);
        return Integer.parseInt(input);
    }


    public static List<Integer> convertToList(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    public static void isEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE);
        }
    }

    public static void isNumeric(String input) {
        if (!Pattern.matches(Constants.NUMERIC_REGEX, input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMERIC);
        }
    }

    public static void isThousandUnit(String input) {
        if (Integer.parseInt(input) % Constants.UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_THOUSAND_UNIT);
        }
    }

    public static void isValidCommaSeparator(String input) {
        if (!Pattern.matches(Constants.VALID_COMMA_SEPARATOR_REGEX, input)) {
            throw new IllegalArgumentException(ExceptionMessage.SEPARATOR_CHECK);
        }
    }

    public static void isDuplicateWinNumber(String[] inputs) {
        List<String> numbers = new ArrayList<>();
        for (String input : inputs) {
            if (numbers.contains(input)) {
                throw new IllegalArgumentException(ExceptionMessage.INPUT_NON_DUPLICATE_WIN_NUMBER);
            }
            numbers.add(input);
        }
    }

    public static void isNumberInRange(String input) {
        int number = Integer.parseInt(input);
        if (!(number >= Constants.MIN && number <= Constants.MAX)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_IN_RANGE);
        }
    }

    public static void isSixItems(String[] input) {
        if (input.length != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SIX_ITEMS);
        }
    }
}
