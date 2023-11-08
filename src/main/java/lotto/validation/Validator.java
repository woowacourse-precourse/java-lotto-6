package lotto.validation;

import lotto.exception.InvalidDuplicateNumberException;
import lotto.exception.InvalidPaymentAmountException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INVALID_NUMERIC_REGEX = "\\d+";

    public static int validateNumeric(String number, String message) {
        if (!number.matches(INVALID_NUMERIC_REGEX)) {
            throw new InvalidPaymentAmountException(ERROR_MESSAGE + message + " 입력시 숫자(정수)만 입력 가능합니다.");
        }
        return Integer.parseInt(number);
    }

    public static void validateDuplicateNumber(List<Integer> enteredNumbers, String category) {
        Set<Integer> uniqueItems = new HashSet<>();
        List<Integer> duplicates = enteredNumbers.stream()
                .filter(item -> !uniqueItems.add(item))
                .toList();
        if (duplicates.size() > 0) {
            throw new InvalidDuplicateNumberException(ERROR_MESSAGE + category + " 번호는 중복될 수 없습니다.");
        }
    }
}
