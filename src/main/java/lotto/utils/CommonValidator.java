package lotto.utils;

public class CommonValidator {
    private static String EMPTY_INPUT_MESSAGE = "입력값이 없습니다.";

    public static void validateEmptyString(String inputNumber) {
        if (inputNumber == null || inputNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
    }

}
