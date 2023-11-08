package lotto.utils;

import java.util.List;
import lotto.constants.Error;

public class Validator {
    private static final String ERROR_MESSAGE_HEADER = Error.ERROR_HEADER.getMessage();

    private Validator() {
    }

    public static void validateIsNumber(String input) {
        boolean isNotNumber = !input.chars().allMatch(Character::isDigit);
        if (isNotNumber) {
            raiseIllegalArgumentException(ERROR_MESSAGE_HEADER + " 숫자만 입력해주세요.");
        }
    }

    public static void validateNotLessThan(int checkingNumber, int standardNumber) {
        if (checkingNumber < standardNumber) {
            raiseIllegalArgumentException(ERROR_MESSAGE_HEADER + " " + standardNumber + " 이상의 수를 입력하세요.");
        }
    }

    public static void validateNotGreaterThan(int checkingNumber, int standardNumber) {
        if (checkingNumber > standardNumber) {
            raiseIllegalArgumentException(ERROR_MESSAGE_HEADER + " " + standardNumber + " 이하의 수를 입력하세요.");
        }
    }

    public static void validateIsDivisor(int dividend, int divisor) {
        boolean canNotDivide = !(dividend % divisor == 0);
        if (canNotDivide) {
            raiseIllegalArgumentException(ERROR_MESSAGE_HEADER + " " + divisor + "단위 이상으로 입력하세요.");
        }
    }

    public static void validateSize(int size, int limit) {
        boolean notMatchSize = size != limit;
        if (notMatchSize) {
            raiseIllegalArgumentException(ERROR_MESSAGE_HEADER + " " + limit + "개만큼 입력하세요.");
        }
    }

    public static void validateUniqueNumbersInRange(
            List<Integer> numbers,
            int startInclusive,
            int endInclusive
    ) {
        validateRange(startInclusive, endInclusive);
        boolean isNotValidNumbers = (
                numbers.stream()
                        .filter(number -> number >= startInclusive && number <= endInclusive)
                        .distinct().count() != numbers.size()
        );
        if (isNotValidNumbers) {
            raiseIllegalArgumentException(ERROR_MESSAGE_HEADER + " 중복되지 않는 " +
                    startInclusive + "이상 " + endInclusive + "이하의 숫자만 입력해주세요.");
        }
    }

    private static void validateRange(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            raiseIllegalArgumentException("startInclusive cannot be greater than endInclusive.");
        }
        if (endInclusive == Integer.MAX_VALUE) {
            raiseIllegalArgumentException("endInclusive cannot be greater than Integer.MAX_VALUE.");
        }
        if (endInclusive - startInclusive >= Integer.MAX_VALUE) {
            raiseIllegalArgumentException("the input range is too large.");
        }
    }

    private static void raiseIllegalArgumentException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

}
