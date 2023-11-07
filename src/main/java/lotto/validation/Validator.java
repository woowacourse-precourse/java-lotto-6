package lotto.validation;

import lotto.exception.InvalidDuplicateNumberException;
import lotto.exception.InvalidPaymentAmountException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INVALID_NUMERIC_REGEX = "\\d+";
    private static final String COMMA = ",";


    public static void validateNumeric(String enteredPrice) {
        if (!enteredPrice.matches(INVALID_NUMERIC_REGEX)) {
            throw new InvalidPaymentAmountException(ERROR_MESSAGE + "구입 금액 입력시 숫자(정수)만 입력 가능합니다.");
        }
    }

    public static List<String> validateDuplicateNumber(String enteredNumbers) {
        List<String> defaultWinningNumbers = List.of(enteredNumbers.split(COMMA));
        Set<String> uniqueItems = new HashSet<>();
        List<String> duplicates = defaultWinningNumbers.stream()
                .filter(item -> !uniqueItems.add(item))
                .toList();
        if (duplicates.size() > 0) {
            throw new InvalidDuplicateNumberException(ERROR_MESSAGE + "입력 번호는 중복될 수 없습니다.");
        }

        return defaultWinningNumbers;
    }
}
