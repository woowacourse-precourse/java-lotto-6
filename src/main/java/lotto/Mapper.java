package lotto;

import lotto.domain.common.Money;

import java.util.Objects;

class Mapper {

    private static final String UNKNOWN_INPUT_MESSAGE = "알 수 없는 입력입니다.";
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자 형식으로 입력해주세요.";

    public static Money mapToMoney(String input) {
        checkInputNonNull(input);

        return Money.from(parseLong(input));
    }

    private static void checkInputNonNull(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(UNKNOWN_INPUT_MESSAGE);
        }
    }

    private static long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }
}
