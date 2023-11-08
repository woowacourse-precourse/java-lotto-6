package utils;

import java.util.List;

public class NumbersValidation {
    private static final int MAX_INPUT_LENGTH = 6;
    private static final String INPUT_OVER_LENGTH = "[ERROR] 입력은 6자 이하여야 합니다.";
    private static final String INPUT_UNDER_LENGTH = "[ERROR] 입력은 6자 보다 작을 수 없습니다.";
    private static final String INPUT_DUPLICATION = "[ERROR] 입력 숫자들은 중복될 수 없습니다.";

    public static void isOverLength(List<Integer> numbers) {
        if (numbers.size() > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_OVER_LENGTH);
        }
    }

    public static void isUnderLength(List<Integer> numbers) {
        if (numbers.size() < MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_UNDER_LENGTH);
        }
    }

    public static void duplicationNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() < MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_DUPLICATION);
        }
    }
}
