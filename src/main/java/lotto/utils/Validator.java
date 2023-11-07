package lotto.utils;

import lotto.domain.Lotto;
import lotto.exception.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Long.parseLong;
import static lotto.domain.constant.NumberConstant.*;

public class Validator {
    // Lotto DOMAIN
    public static void validateLotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberInRange(numbers);
    }


    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE)
            throw new InvalidLottoSizeException();
    }


    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer n : numbers)
            if (!uniqueNumbers.add(n))
                throw new DuplicateLottoException();
    }


    public static void validateNumberInRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < LOTTO_NUMBER_START || n > LOTTO_NUMBER_END))
            throw new LottoNumOutOfRangeException();
    }


    // InputService SERVICE
    public static void validateExpenseValue(Long expense) {
        if (expense < MIN_EXPENSE_VALUE)
            throw new InvalidExpenseValueException();

        if (expense % LOTTO_PRICE > ZERO)
            throw new NonDividableExpenseValueException();
    }


    public static void validateNumberType(String input) {
        try {
            parseLong(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberTypeException();
        }
    }


    public static void validateBonusNumInRange(int bonusNum) {
        if (bonusNum < LOTTO_NUMBER_START || bonusNum > LOTTO_NUMBER_END)
            throw new LottoNumOutOfRangeException();
    }


    public static void validateBonusNumDuplicate(int bonusNum, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(bonusNum))
            throw new DuplicateBonusNumException();
    }
}