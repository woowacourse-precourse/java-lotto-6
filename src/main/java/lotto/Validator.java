package lotto;

import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void validateMoney(int money) {
        if (money % 1000 != 0 || money == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또는 천원 단위로만 구매할 수 있습니다.");
        }
    }

    public static final void canNumber(String requestString) {
        try {
            Integer.parseInt(requestString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 숫자만 입력 가능합니다.");
        }
    }

    public static final void canList(String requestString) {
        try {
            int length = Arrays.stream(requestString.split(","))
                    .map(Integer::parseInt)
                    .toArray().length;
            if (length == 6) return;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "길이는 6이어야 합니다.");
        }
    }

    public static final void isDifferent(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "로또는 중복되지 않는 숫자여야 합니다.");
        }
    }
}
