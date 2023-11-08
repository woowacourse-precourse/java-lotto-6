package lotto.utils;

import lotto.domain.Lotto;
import lotto.exception.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static lotto.domain.constant.NumberConstant.*;

public class Validator {
    // Lotto DOMAIN
    public static void validateLotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberInRange(numbers);
    }


    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE)
            throw new InvalidLottoSizeException();
    }


    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer n : numbers)
            if (!uniqueNumbers.add(n))
                throw new DuplicateLottoException();
    }


    private static void validateNumberInRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < LOTTO_NUMBER_START || n > LOTTO_NUMBER_END))
            throw new LottoNumOutOfRangeException();
    }


    // InputService SERVICE
    private static void validateNumberType(String input) {
        try {
            parseLong(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberTypeException();
        }
    }


    // expense
    public static void validateExpense(String input) {
        validateNumberType(input);

        long expense = parseLong(input);
        validateExpenseMin(expense);
        validateExpenseDividable(expense);
    }

    private static void validateExpenseMin(Long expense) {
        if (expense <= MIN_EXPENSE_VALUE)
            throw new InvalidExpenseValueException();
    }

    private static void validateExpenseDividable(Long expense) {
        if (expense % LOTTO_PRICE > ZERO)
            throw new NonDividableExpenseValueException();
    }


    // winningLotto
    public static void validateLottoNumType(String[] input) {
        for (String s : input)
            try {
                parseInt(s);
            } catch (NumberFormatException e) {
                throw new InvalidNumberTypeException();
            }
    }


    // bonusNum
    public static void validateBonusNum(String input, Lotto winningLotto) {
        validateNumberType(input);

        int bonusNum = parseInt(input);
        validateBonusNumInRange(bonusNum);
        validateBonusNumDuplicate(bonusNum, winningLotto);
    }

    private static void validateBonusNumInRange(int bonusNum) {
        if (bonusNum < LOTTO_NUMBER_START || bonusNum > LOTTO_NUMBER_END)
            throw new LottoNumOutOfRangeException();
    }

    private static void validateBonusNumDuplicate(int bonusNum, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(bonusNum))
            throw new DuplicateBonusNumException();
    }
}