package lotto.utils;

import lotto.enums.ErrorMessage;

import java.util.*;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private final static int MinimumAmount = 1000;
    private final static int MinimumRange = 1;
    private final static int MaximumRange = 45;

    private static Set<String> numberSet;

    public static boolean checkAmount(String amount) {
        if (validateAmountHasText(amount)) {
            return true;
        }
        if (validateInteger(amount)) {
            return true;
        }
        if (validateMinimum(amount)) {
            return true;
        }
        if (validateDivided(amount)) {
            return true;
        }
        return false;
    }

    public static boolean checkNumbers(String[] numbers) {
        numberSet = new HashSet<>();
        if (validateNumberCount(numbers)) {
            return true;
        }
        for (String number : numbers) {
            if (checkNumber(number)) {
                return true;
            }
            if (validateSameNumber(number)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkNumber(String number) {
        if (validateNumberHasText(number)) {
            return true;
        }
        if (validateInteger(number)) {
            return true;
        }
        if (validateRange(number)) {
            return true;
        }
        return false;
    }

    private static boolean validateAmountHasText(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_AMOUNT.getMessage());
        }
        return false;
    }

    private static boolean validateNumberHasText(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NUMBER.getMessage());
        }
        return false;
    }

    private static boolean validateInteger(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage());
        }
        return false;
    }


    private static boolean validateDivided(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_BY_1000.getMessage());
        }
        return false;
    }

    private static boolean validateMinimum(String input) {
        if (Integer.parseInt(input) < MinimumAmount) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THEN_MINIMUM.getMessage());
        }
        return false;
    }

    private static boolean validateRange(String input) {
        if (!isInRange(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_INRANGE.getMessage());
        }
        return false;
    }

    private static boolean isInRange(String input) {
        if (Integer.parseInt(input) < MinimumRange || Integer.parseInt(input) > MaximumRange) {
            return false;
        }
        return true;
    }

    private static boolean validateNumberCount(String[] numbers) {
        if (Arrays.stream(numbers).count() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_6.getMessage());
        }
        return false;
    }

    private static boolean validateSameNumber(String input) {
        if (!numberSet.add(input)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUBPLICATE.getMessage());
        }
        return false;
    }

    public static void DuplicateBonusNumber(String[] numbers, String bonusNumber) {
        for (String number : numbers) {
            if (number != null && number.equals(bonusNumber)) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_DUBPLICATE_BONUS_NUMBER.getMessage());
            }
        }
    }
}
