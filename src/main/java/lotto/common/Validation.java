package lotto.common;

import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoConst.*;

public class Validation {

    public static void validateLotto(List<Integer> numbers) {
        try {
            if (numbers.size() != LOTTO_SIZE) throw new IllegalArgumentException();
            validateOutOfRange(numbers);
            validateDuplicateNum(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INPUT_WINNING_NUMS_NUMBER);
        }
    }

    public static int validatePurchaseMoney(String input) {
        try {
            int parseInput = Integer.parseInt(input);
            if (parseInput < LOTTO_PRICE) throw new IllegalArgumentException(NOT_PURCHASE_MONEY_OVER_1000);
            if (parseInput % LOTTO_PRICE != ZERO) throw new IllegalArgumentException(NOT_PURCHASE_MONEY_DIVIDE_1000);
            return parseInput;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INPUT_NUMBER);
        }
    }

    public static void validateWinningNumbers(List<Integer> winningNums) {
        try {
            if (winningNums.size() != LOTTO_SIZE) throw new IllegalArgumentException(NOT_LOTTO_SIZE);

            validateOutOfRange(winningNums);
            validateDuplicateNum(winningNums);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INPUT_WINNING_NUMS_NUMBER);
        }
    }
    public static void validateBonusNum(List<Integer> winningNums, int bonusNum) {
        try {
            if (winningNums.contains(bonusNum)) throw new IllegalArgumentException(DUPLICATE_NUMS);
            if (bonusNum < LOTTO_MIN_NUM || bonusNum > LOTTO_MAX_NUM) throw new IllegalArgumentException(NOT_INPUT_NUM_IN_RANGE);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INPUT_BONUS_NUMBER);
        }
    }

    private static void validateOutOfRange(List<Integer> winningNums) {
        for (int num : winningNums) {
            if (num < LOTTO_MIN_NUM || num > LOTTO_MAX_NUM) throw new IllegalArgumentException(NOT_INPUT_NUM_IN_RANGE);
        }
    }

    private static void validateDuplicateNum(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < numbers.size(); j++) {
            if (set.contains(numbers.get(j))) throw new IllegalArgumentException(DUPLICATE_NUMS);
            set.add(numbers.get(j));
        }
    }
}
