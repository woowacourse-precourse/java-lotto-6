package lotto.validator;

import lotto.app.AppConstant;

public class RangeValidator {

    public static String ILLEGAL_INPUT_MESSAGE = "범위 검사는 숫자만 할 수 있습니다.";

    private RangeValidator() {
    }

    public static void validateInputRange(
        final int value,
        final int min,
        final int max
    ) {

        if (value < min || value > max) {
            throw new IllegalArgumentException(makeOutOfBoundMessage(value, min, max));
        }
    }

    public static String makeOutOfBoundMessage(
        final int value,
        final int min,
        final int max
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append(AppConstant.ERROR_FLAG)
            .append("허용된 범위를 벗어난 입력입니다.")
            .append("입력: ").append(value)
            .append(", 최솟값: ").append(min)
            .append(", 최댓값: ").append(max);
        return sb.toString();
    }

}
