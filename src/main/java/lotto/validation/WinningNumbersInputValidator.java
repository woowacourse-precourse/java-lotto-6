package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersInputValidator {
    private static final String NOT_SIX_DIGIT_EXCEPTION_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "로또 번호에 중복된 숫자가 있습니다.";
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1~45 사이의 숫자여야 합니다.";
    private static final String STRING_SEPARATION_EXCEPTION_MESSAGE = "로또 번호는 쉼표(,)로 구분되어야 합니다.";

    public static void validate(String numbers) {
        if (!numbers.contains(",")) {
            throw new IllegalArgumentException(STRING_SEPARATION_EXCEPTION_MESSAGE);
        }

        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList();

        checkNumberOfNumbers(numberList);
        checkDuplication(numberList);
        checkNumberRange(numberList);
    }

    private static void checkNumberOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private static void checkDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private static void checkNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

}
