package lotto.utils;

import java.util.List;

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

    public static void validateListSize(int size, int limit) {
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
        boolean isNotValidateNumbers =
                numbers.stream()
                        .filter(number -> number >= startInclusive && number <= endInclusive)
                        .distinct().count() != numbers.size();
        if (isNotValidateNumbers) {
            raiseIllegalArgumentException(
                    ERROR_MESSAGE_HEADER +
                            " 중복되지 않는 " +
                            startInclusive + "이상 " +
                            endInclusive + "이하의 숫자만 입력해주세요.");
        }
    }

    private static void validateRange(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive cannot be greater than endInclusive.");
        }
        if (endInclusive == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("endInclusive cannot be greater than Integer.MAX_VALUE.");
        }
        if (endInclusive - startInclusive >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("the input range is too large.");
        }
    }

    private static void raiseIllegalArgumentException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

}
