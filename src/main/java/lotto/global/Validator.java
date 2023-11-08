package lotto.global;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoCondition;
import lotto.global.exception.ErrorMessage;

public class Validator {
    public static void checkAmount(Integer amount) {
        if (amount % LottoCondition.MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_AMOUNT);
        }
    }

    public static void checkBonusNumber(Integer bonusNumber, List<Integer> winNumbers) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE);
        }
        if (!isInRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE);
        }
    }

    public static void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoCondition.NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT);
        }
    }

    public static void checkAllInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (!isInRange(number)) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE);
            }
        });
    }

    public static void checkDuplicate(List<Integer> numbers) {
        List<Integer> nondupliacteNumbers = new ArrayList<>();
        numbers.forEach(number -> {
            if (nondupliacteNumbers.contains(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE);
            }
            nondupliacteNumbers.add(number);
        });
    }

    private static Boolean isInRange(Integer number) {
        return number >= LottoCondition.MIN_NUMBER && number <= LottoCondition.MAX_NUMBER;
    }
}
