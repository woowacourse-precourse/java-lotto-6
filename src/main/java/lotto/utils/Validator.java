package lotto.utils;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Long.parseLong;
import static lotto.service.OutputService.printError;
import static lotto.domain.constant.NumberConstant.*;
import static lotto.domain.constant.StringConstant.*;

public class Validator {
    // Lotto DOMAIN
    public static void validateLotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberInRange(numbers);
    }


    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            printError(LOTTO_SIZE_ERROR);
            throw new IllegalArgumentException();
        }
    }


    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer n : numbers)
            if (!uniqueNumbers.add(n)) {
                printError(LOTTO_DUPLICATE_ERROR);
                throw new IllegalArgumentException();
            }
    }


    public static void validateNumberInRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < LOTTO_NUMBER_START || n > LOTTO_NUMBER_END)) {
            printError(LOTTO_IN_RANGE_ERROR);
            throw new IllegalArgumentException();
        }
    }


    // InputService SERVICE
    public static void validateExpenseValue(String input) {
        for (int i = 1; i < 4; i++)
            if (input.charAt(input.length() - i) != '0') {
                printError(LOTTO_EXPENSE_VALUE_ERROR);
                throw new IllegalArgumentException();
            }
    }


    public static void validateNumberType(String input) {
        try {
            parseLong(input);
        } catch (NumberFormatException e) {
            printError(LOTTO_NUM_TYPE_ERROR);
            throw new IllegalArgumentException();
        }
    }


    public static void validateBonusNumInRange(int bonusNum) {
        if (bonusNum < LOTTO_NUMBER_START || bonusNum > LOTTO_NUMBER_END)  {
            printError(LOTTO_IN_RANGE_ERROR);
            throw new IllegalArgumentException();
        }
    }


    public static void validateBonusNumDuplicate(int bonusNum, Lotto winningLotto) {
        if (winningLotto.getNumbers().contains(bonusNum)) {
            printError(LOTTO_BONUSNUM_DUPLICATE_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
