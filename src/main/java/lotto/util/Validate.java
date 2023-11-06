package lotto.util;

import static lotto.util.message.Error.MUST_LOTTO_NO_DUP;
import static lotto.util.message.Error.MUST_LOTTO_RANGE;
import static lotto.util.message.Error.MUST_LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(MUST_LOTTO_SIZE);
        }
    }

    public static void validateDuplication(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>(numbers);

        if (check.size() != numbers.size()) {
            throw new IllegalArgumentException(MUST_LOTTO_NO_DUP);
        }
    }

    public static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !(0 <= number && number <= 45))) {
            throw new IllegalArgumentException(MUST_LOTTO_RANGE);
        }
    }
}
