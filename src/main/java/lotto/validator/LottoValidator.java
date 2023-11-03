package lotto.validator;

import java.util.List;
import lotto.exception.domain.lotto.LottoDuplicateNumException;
import lotto.exception.domain.lotto.LottoNumRangeException;
import lotto.exception.domain.lotto.LottoSizeException;

public class LottoValidator {

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoSizeException();
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        long uniqueLottoNumSize = numbers.stream()
                .distinct()
                .count();

        if (uniqueLottoNumSize != 6) {
            throw new LottoDuplicateNumException();
        }
    }

    public static void validateRangeOfNumber(List<Integer> winningNumbers) {
        if (hasInvalidRangeNumber(winningNumbers)) {
            throw new LottoNumRangeException();
        }
    }

    public static void validateRangeOfNumber(Integer bonusNumber) {
        if (!isValidRange(bonusNumber)) {
            throw new LottoNumRangeException();
        }
    }

    private static boolean hasInvalidRangeNumber(List<Integer> winningNumbers) {
        return !winningNumbers.stream()
                .allMatch(num -> isValidRange(num));
    }

    private static boolean isValidRange(Integer num) {
        return num >= 1 && num <= 45;
    }
}
