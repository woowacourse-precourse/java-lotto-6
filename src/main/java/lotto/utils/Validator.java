package lotto.utils;

import java.util.List;
import lotto.config.LottoGameRule;
import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidSizeException;
import lotto.exception.LottoNumberOutOfRangeException;

public class Validator {

    public static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new DuplicateNumberException();
        }
    }

    public static void validateInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoGameRule.LOTTO_MIN_VALUE.value()
                    || number > LottoGameRule.LOTTO_MAX_VALUE.value()) {
                throw new LottoNumberOutOfRangeException();
            }
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoGameRule.LOTTO_SIZE.value()) {
            throw new InvalidSizeException();
        }
    }
}
