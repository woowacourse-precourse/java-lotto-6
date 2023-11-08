package lotto.util;

import static lotto.util.ConstantUtils.LOTTO_SIZE_CRITERION;

import java.util.List;

public class ValidationUtils {

    public static void validateNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해야 합니다.");
        }
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException("로또는 숫자 여섯 개로 이루어져야 합니다.");
        }
    }
}
