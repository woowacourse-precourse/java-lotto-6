package lotto.utils;

public class Validator {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR]";

    private Validator() {
    }

    public static void validateStringIsNumber(String string) {
        boolean isNotNumber = !string.chars().allMatch(Character::isDigit);
        if (isNotNumber) {
            raiseIllegalArgumentException(ERROR_MESSAGE_HEADER + " 숫자만 입력해주세요.");
        }
    }

    public static void validateDivisor(int dividend, int divisor) {
        boolean canNotDivide = !(dividend % divisor == 0);
        if (canNotDivide) {
            raiseIllegalArgumentException(ERROR_MESSAGE_HEADER + " " + divisor + " 단위로만 입력하세요.");
        }
    }

    private static void raiseIllegalArgumentException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
