package lotto.model;

import java.util.HashSet;
import java.util.Set;

public class WinningNumbers {
    private static final String ERROR_NULL_OR_EMPTY_WINNING_NUMBER = "당첨번호를 입력하세요.";
    private static final String ERROR_INVALID_INPUT_TYPE = "유효하지 않은 타입입니다. 숫자로 입력해주세요.";
    private static final String ERROR_LESS_OR_OVER_COUNT_OF_NUMBER = "당첨 번호는 6개로 구성해 주세요.";
    private static final String ERROR_INVALID_DUPLICATED_NUMBER = "서로 다른 번호를 입력해 주세요.";
    private static final String ERROR_INPUT_NUMBER_NOT_IN_RANGE = "1-45 사이의 값을 입력해 주세요.";
    private Set<Integer> winningNumbers;

    public WinningNumbers(String[] numbers) {
        this.winningNumbers = parseAndValidateNumbers(numbers);
    }

    public Set<Integer> getNumbers() {
        return winningNumbers;
    }

    private Set<Integer> parseAndValidateNumbers(String[] numbers) {
        validateNotNullOrEmpty(numbers);
        Set<Integer> checkingNumbers = new HashSet<>();
        for (String number : numbers) {
            int parsedNumber = parseAndValidateSingleNumber(number);
            if (checkingNumbers.contains(parsedNumber)) {
                throw new IllegalArgumentException(ERROR_INVALID_DUPLICATED_NUMBER);
            }
            checkingNumbers.add(parsedNumber);
        }
        if (checkingNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LESS_OR_OVER_COUNT_OF_NUMBER);
        }
        return checkingNumbers;
    }

    private void validateNotNullOrEmpty(String[] numberStrings) {
        if (numberStrings == null || numberStrings.length == 0) {
            throw new IllegalArgumentException(ERROR_NULL_OR_EMPTY_WINNING_NUMBER);
        }
        for (String numberStr : numberStrings) {
            if (numberStr == null || numberStr.trim().isEmpty()) {
                throw new IllegalArgumentException(ERROR_NULL_OR_EMPTY_WINNING_NUMBER);
            }
        }
    }

    private int parseAndValidateSingleNumber(String numberStr) {
        int parsedNumber;
        try {
            parsedNumber = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_TYPE);
        }
        validateNumber(parsedNumber);
        return parsedNumber;
    }

    private void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_INPUT_NUMBER_NOT_IN_RANGE);
        }
    }
}