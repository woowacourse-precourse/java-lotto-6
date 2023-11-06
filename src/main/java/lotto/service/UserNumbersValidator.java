package lotto.service;

import java.util.Collections;
import java.util.List;

public class UserNumbersValidator {
    private static final String DELIMITER = ",";
    private static final String ONLY_NUMBER_DELIMITER = "^[0-9, ]*$";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static String preValidate(String userInput) {
        // Only number
        numberValidate(userInput);
        // Delimiter starting
        delimiterStartValidate(userInput);
        // Delimiter ending
        delimiterEndValidate(userInput);
        // Delimiter 뒤에 DELIMITER가 오는지 검증
        delimiterDoubleValidate(userInput);

        return userInput;
    }

    // Only number
    private static void numberValidate(String userInput) {
        if (!userInput.matches(ONLY_NUMBER_DELIMITER)) {
            throw new IllegalArgumentException(UserNumbersValidateStatus.PRE_NUMBERS_DELIMITER_ERROR.get());
        }
    }

    // Delimiter starting
    private static void delimiterStartValidate(String userInput) {
        if (userInput.startsWith(DELIMITER)) {
            throw new IllegalArgumentException(UserNumbersValidateStatus.DELIMITER_START_END_ERROR.get());
        }
    }

    // Delimiter ending
    private static void delimiterEndValidate(String userInput) {
        if (userInput.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(UserNumbersValidateStatus.DELIMITER_START_END_ERROR.get());
        }
    }

    // Delimiter 뒤에 DELIMITER가 오는지 검증
    private static void delimiterDoubleValidate(String userInput) {
        if (userInput.contains(DELIMITER + DELIMITER)) {
            throw new IllegalArgumentException(UserNumbersValidateStatus.DELIMITER_DOUBLE_ERROR.get());
        }
    }

    public static List<Integer> postValidate(List<Integer> numbers) {
        // 사이즈 검증
        validateSize(numbers);
        // 중복 검증
        validateDuplicatedNumber(numbers);
        // 범위 검증
        validateRange(numbers);

        return numbers;
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalStateException(UserNumbersValidateStatus.LOTTO_NUMBERS_SIZE_ERROR.get());
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numbers) {
        boolean duplicate = numbers.stream().distinct().count() != numbers.size();

        if (duplicate) {
            throw new IllegalStateException(UserNumbersValidateStatus.LOTTO_NUMBERS_DUPLICATE_ERROR.get());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        maxValidate(numbers);
        minValidate(numbers);
    }

    private static void maxValidate(List<Integer> numbers) {
        if (Collections.max(numbers) > MAX_NUMBER) {
            throw new NumberFormatException(UserNumbersValidateStatus.LOTTO_NUMBERS_ERROR.get());
        }
    }

    private static void minValidate(List<Integer> numbers) {
        if (Collections.min(numbers) < MIN_NUMBER) {
            throw new NumberFormatException(UserNumbersValidateStatus.LOTTO_NUMBERS_ERROR.get());
        }
    }
}
