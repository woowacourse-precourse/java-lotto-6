package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Constants.*;

public class LottoValidator {

    public static void validateLotteryLength(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_DIGIT_LENGTH) {
            throw new IllegalArgumentException(ERROR_INCORRECT_LENGTH);
        }
    }

    public static void validateNumberInRange(Integer number) {
        if (number > LOTTERY_MAX_NUMBER || number < LOTTERY_MIN_NUMBER) {
            throw new IllegalArgumentException(ERROR_INCORRECT_RANGE);
        }
    }

    public static void validateUniqueNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() < numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_NUMBER);
        }
    }
}
