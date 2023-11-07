package lotto.validator;

import static lotto.message.ErrorMessage.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumbers;

public class Validator {

    private static final int minNum = 1;
    private static final int maxNum = 45;
    private static final int lottoLength = 6;
    private static final Long price = 1000L;
    private static final Long priceUpperLimit = 1000000L;
    private static final Long priceLowerLimit = 0L;

    public static void validateMoneyLimit(Long target) {
        if (target <= priceLowerLimit || priceUpperLimit < target) {
            throw new IllegalArgumentException(MONEY_LIMIT_EXCEEDED_EXCEPTION);
        }
    }

    public static void validateMoneyModNoneZero(Long target) {
        if (target % price != 0) {
            throw new IllegalArgumentException(MONEY_MOD_NONE_ZERO_EXCEPTION);
        }
    }

    public static void validateNumberCount(List<Integer> target) {
        if (target.size() != lottoLength) {
            throw new IllegalArgumentException(NUMBER_COUNT_EXCEPTION);
        }
    }

    public static void validateNumberRange(List<Integer> target) {
        for (int number : target) {
            if (number < minNum || maxNum < number) {
                throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION);
            }
        }
    }

    public static void validateNumberRange(Integer target) {
        if (target < minNum || maxNum < target) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION);
        }
    }

    public static void validateDuplicateNumber(List<Integer> target) {
        Map<Integer, Long> counter = target.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        for (Long value : counter.values()) {
            if (value > 1) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION);
            }
        }
    }

    public static void validateDuplicateNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION);
        }
    }
}
