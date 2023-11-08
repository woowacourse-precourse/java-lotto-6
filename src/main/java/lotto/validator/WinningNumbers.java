package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final String ERROR_NULL_WINNING_NUMBER = "당첨번호를 입력하세요.";
    private static final String ERROR_EMPTY_WINNING_NUMBER = "6개의 입력값 중 공백이 포함 되었는지 확인하세요.";
    private static final String ERROR_INVALID_INPUT_TYPE = "유효하지 않은 타입입니다. 숫자로 입력해주세요.";
    private static final String ERROR_LESS_OR_OVER_COUNT_OF_NUMBER = "당첨 번호는 6개로 구성해 주세요.";
    private static final String ERROR_INVALID_DUPLICATED_NUMBER = "서로 다른 번호를 입력해 주세요.";
    private static final String ERROR_INPUT_NUMBER_NOT_IN_RANGE = "1-45 사이의 값을 입력해 주세요.";
    private final Set<Integer> winningNumbers;

    public WinningNumbers(String[] numbers) {
        validateInput(numbers);
        int[] parsedNumbers = parseNumbers(numbers);
        validateWinningNumbers(parsedNumbers);
        this.winningNumbers = convertArrayToSet(parsedNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return new ArrayList<>(winningNumbers);
    }

    private void validateInput(String[] numbers) {
        validateNotNull(numbers);
        validateNotEmptyInput(numbers);
        validateNumbersCount(numbers);
        validateNoDuplicates(numbers);
    }

    private void validateWinningNumbers(int[] numbers) {
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    private void validateNotNull(String[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException(ERROR_NULL_WINNING_NUMBER);
        }
    }

    private void validateNotEmptyInput(String[] numbers) {
        for (String number : numbers) {
            if (number == null || number.trim().isEmpty()) {
                throw new IllegalArgumentException(ERROR_EMPTY_WINNING_NUMBER);
            }
        }
    }

    private void validateNumbersCount(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException(ERROR_LESS_OR_OVER_COUNT_OF_NUMBER);
        }
    }

    private void validateNoDuplicates(String[] numbers) {
        Set<String> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            if (!uniqueNumbers.add(number.trim())) {
                throw new IllegalArgumentException(ERROR_INVALID_DUPLICATED_NUMBER);
            }
        }
    }

    private int[] parseNumbers(String[] numbers) {
        return java.util.Arrays.stream(numbers)
                .mapToInt(number -> {
                    try {
                        return Integer.parseInt(number);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(ERROR_INVALID_INPUT_TYPE);
                    }
                })
                .toArray();
    }

    private void validateNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_INPUT_NUMBER_NOT_IN_RANGE);
        }
    }

    private Set<Integer> convertArrayToSet(int[] numbers) {
        Set<Integer> winningNumbers = new HashSet<>();
        for (int number : numbers) {
            winningNumbers.add(number);
        }
        return winningNumbers;
    }
}