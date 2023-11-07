package lotto.util;

import static lotto.util.message.Digit.LOTTO_RANGE_END;
import static lotto.util.message.Digit.LOTTO_RANGE_START;
import static lotto.util.message.Digit.LOTTO_SIZE;
import static lotto.util.message.Error.MUST_LOTTO_NO_DUP;
import static lotto.util.message.Error.MUST_LOTTO_RANGE;
import static lotto.util.message.Error.MUST_LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException(MUST_LOTTO_SIZE.getError(LOTTO_SIZE.getNumber()));
        }
    }

    public static void validateDuplication(List<Integer> numbers) {
        Set<Integer> check = new HashSet<>(numbers);

        if (check.size() != numbers.size()) {
            throw new IllegalArgumentException(MUST_LOTTO_NO_DUP.getError());
        }
    }

    public static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(
                number -> !(LOTTO_RANGE_START.getNumber() <= number && number <= LOTTO_RANGE_END.getNumber()))) {
            throw new IllegalArgumentException(MUST_LOTTO_RANGE.getError(LOTTO_RANGE_START.getNumber(),
                    LOTTO_RANGE_END.getNumber()));
        }
    }
}
