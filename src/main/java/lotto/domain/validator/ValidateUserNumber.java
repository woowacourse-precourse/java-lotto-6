package lotto.domain.validator;

import java.util.List;

public class ValidateUserNumber {

    private static final int ABSOLUTE_SIX = 6;
    private static final int MAX_RANGE = 45;
    private static final int MIN_RANGE = 1;
    private static final String ERROR_HEAD = "[ERROR] ";
    private static final String ERROR_LENGTH_INVALID = "6개의 숫자를 입력 해주세요";
    private static final String ERROR_RANGE = "숫자는 1부터 45까지 입력 가능합니다.";
    private static final String ERROR_DUPLICATE_NUMBER = "중복되지 않는 숫자를 입력 해주세요.";

    public static void isLengthSix(List<Integer> numbers) {
        if (numbers.size() != ABSOLUTE_SIX) {
            throw new IllegalArgumentException(ERROR_HEAD + ERROR_LENGTH_INVALID);
        }
    }

    public static void isInRange(List<Integer> numbers) {
        if (check(numbers)) {
            throw new IllegalArgumentException(ERROR_HEAD + ERROR_RANGE);
        }
    }

    private static boolean check(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number > MAX_RANGE || number < MIN_RANGE);
    }

    public static void isDuplicate(List<Integer> numbers) {
        int check = (int) numbers.stream().distinct().count();
        if (numbers.size() != check) {
            throw new IllegalArgumentException(ERROR_HEAD + ERROR_DUPLICATE_NUMBER);
        }
    }
}
