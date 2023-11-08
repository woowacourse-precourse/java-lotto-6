package lotto.util;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import static lotto.message.ErrorMessage.*;
import lotto.model.Lotto;

public class Validator {
    private static final int MONEY_UNIT = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validateLottoPurchaseAmount(String money) {
        try {
            int moneyNum = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                    NUMERIC_INPUT_ERROR.getMessage());
        }
        int moneyNum = Integer.parseInt(money);
        checkDivisibleByMoneyUnit(moneyNum);
        checkExistOfValue(money);
        checkNegativeNumber(moneyNum);
    }

    public static void validateWinningNumbers(List<String> winningNumbers) {
        checkSize(winningNumbers.size());
        checkDuplicate(winningNumbers);
        for (var winningNumber : winningNumbers) {
            int num = Integer.parseInt(winningNumber);
            checkExistOfValue(winningNumber);
            checkNegativeNumber(num);
            checkRange(num);
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        int num = Integer.parseInt(bonusNumber);
        checkExistOfValue(bonusNumber);
        checkRange(num);
        checkNegativeNumber(num);
    }

    public static void checkAlreadyExist(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ALREADY_EXIST_ERROR.getMessage());
        }
    }

    public static void checkDivisibleByMoneyUnit(int inputValue) {
        if (inputValue % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR.getMessage());
        }
    }

    private static void checkExistOfValue(String inputValue) {
        String input = inputValue.trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EXIST_OF_VALUE_ERROR.getMessage());
        }
    }

    private static void checkNegativeNumber(int inputValue) {
        if (inputValue < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }

    public static void checkSize(int size) {
        if (size != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private static void checkDuplicate(List<String> inputValues) {
        Set<String> deduplicateNumbers  = new HashSet<>(inputValues);
        if (deduplicateNumbers.size() != inputValues.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    public static void checkRange(int inputValue) {
        if (inputValue > MAX_LOTTO_NUMBER || inputValue < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMERIC_RANGE_ERROR.getMessage());
        }
    }
}
