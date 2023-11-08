package lotto.validation;

import java.util.List;

public class LottoValidation {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;

    public static boolean validateRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= LOTTO_START_NUMBER && number <= LOTTO_LAST_NUMBER);
    }
}
