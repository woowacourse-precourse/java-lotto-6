package lotto.service;

import java.util.Collections;
import java.util.List;

public class UserNumbersValidator {
    private static final String ONLY_NUMBER_DELIMITER = "^[0-9,]*$";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static String preValidate(String userInput) {
        // Only number
        if (!userInput.matches(ONLY_NUMBER_DELIMITER)) {
            throw new IllegalArgumentException(UserNumbersValidateEnum.PRE_NUMBERS_DELIMITER_ERROR.get());
        }

        return userInput;
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
            throw new IllegalArgumentException(UserNumbersValidateEnum.LOTTO_NUMBERS_SIZE_ERROR.get());
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numbers) {
        boolean duplicate = numbers.stream().distinct().count() != numbers.size();

        if (duplicate) {
            throw new IllegalArgumentException(UserNumbersValidateEnum.LOTTO_NUMBERS_DUPLICATE_ERROR.get());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        maxValidate(numbers);
        minValidate(numbers);
    }

    private static void maxValidate(List<Integer> numbers) {
        if (Collections.max(numbers) > MAX_NUMBER) {
            throw new IllegalArgumentException(UserNumbersValidateEnum.LOTTO_NUMBERS_ERROR.get());
        }
    }

    private static void minValidate(List<Integer> numbers) {
        if (Collections.min(numbers) < MIN_NUMBER) {
            throw new IllegalArgumentException(UserNumbersValidateEnum.LOTTO_NUMBERS_ERROR.get());
        }
    }
}
