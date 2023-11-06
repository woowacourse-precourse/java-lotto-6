package lotto;

import lotto.domain.common.Money;
import lotto.domain.lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Mapper {

    private static final String UNKNOWN_INPUT_MESSAGE = "알 수 없는 입력입니다.";
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자 형식으로 입력해주세요.";
    private static final String INVALID_NUMBERS_FORMAT_MESSAGE = "숫자를 쉼표로 분리한 형식으로 입력해주세요. ex) 1,2,3,4,5,6";
    private static final String NUMBERS_SPLIT_DELIMITER = ",";

    public static Money mapToMoney(String input) {
        checkInputNonNull(input);

        return Money.from(parseLong(input));
    }

    private static long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    public static Lotto mapToLotto(String input) {
        checkInputNonNull(input);

        return Lotto.from(parseIntList(input));
    }

    private static List<Integer> parseIntList(String input) {
        try {
            return Arrays.stream(input.split(NUMBERS_SPLIT_DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBERS_FORMAT_MESSAGE);
        }
    }

    private static void checkInputNonNull(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(UNKNOWN_INPUT_MESSAGE);
        }
    }
}
