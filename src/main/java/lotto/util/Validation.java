package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.view.ErrorMessage;

public class Validation {
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    private Validation() {
    }

    public static void validateDivisibleNumber(int dividend, int divisor) {
        if (dividend < divisor || dividend % divisor != 0) {
            ErrorMessage.divideNumberError(divisor);
            throw new IllegalArgumentException();
        }
    }

    public static void validateListNumeric(List<String> list) {
        for (String number : list) {
            validateInputIsNumber(number);
        }
    }

    public static void validateInputIsNumber(String input) {
        if (!Pattern.matches(REGEXP_PATTERN_NUMBER, input)) {
            ErrorMessage.inputIsNotNumberError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateListSize(List<Integer> list, int size) {
        if (list.size() != size) {
            ErrorMessage.listSizeError(size);
            throw new IllegalArgumentException();
        }
    }

    public static void validateListDuplication(List<Integer> list) {
        Set<Integer> temp = new HashSet<>(list);
        if (list.size() != temp.size()) {
            ErrorMessage.listDuplicationError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberInList(List<Integer> list, int number) {
        if (list.contains(number)) {
            ErrorMessage.numberNotInListError(number);
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberInRange(int number, int minNumber, int maxNumber) {
        if (minNumber > number || maxNumber < number) {
            ErrorMessage.numberNotInRangeError(minNumber, maxNumber);
            throw new IllegalArgumentException();
        }
    }

    public static void validateListNumbersInRange(List<Integer> list, int minNumber, int maxNumber) {
        for (int number : list) {
            validateNumberInRange(number, minNumber, maxNumber);
        }
    }
}