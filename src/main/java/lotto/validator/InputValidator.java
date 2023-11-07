package lotto.validator;

import lotto.domain.Lotto;
import lotto.service.OutputService;

import java.util.HashSet;
import java.util.List;

import static lotto.ExceptionMessages.*;

public class InputValidator {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int UNIT_NUMBER = 1000;

    public static void validateWinningNumberSize(HashSet<Integer> set) {

        if (set.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(NOT_VALIDATED_WINNING_NUMBER_SIZE.getMessage());
        }
    }

    public static void validateWinningNumberRange(HashSet<Integer> set) {

        for (Integer number : set) {
            validateNumberRange(number);
        }
    }

    public static Integer validateToInteger(String input) {

        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_VALIDATED_INPUT_TYPE.getMessage());
        }
    }

    public static Integer validateCorrectMoney(Integer money) {

        int purchaseAmount = money / UNIT_NUMBER;
        int remainder = money % UNIT_NUMBER;

        if (remainder == 0) {
            return purchaseAmount;
        }

        throw new IllegalArgumentException(NOT_VALIDATED_PURCHASE_AMOUNT.getMessage());
    }

    public static void validateNumberRange(Integer number) {

        if (number > 45 || number < 0) {
            throw new IllegalArgumentException(NOT_VALIDATED_RANGE.getMessage());
        }
    }

    public static void validateDuplicateBonusNumber(HashSet<Integer> winningNumbers, Integer bonusNumber) {

        if (winningNumbers.contains(bonusNumber)) {

            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
