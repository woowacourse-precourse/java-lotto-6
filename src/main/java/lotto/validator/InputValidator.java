package lotto.validator;

import java.util.HashSet;

import static lotto.ExceptionMessages.*;

public class InputValidator {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int UNIT_NUMBER = 1000;

    public static void validateWinningNumberSize(HashSet<Integer> set) {

        if (set.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(NOT_VALIDATED_WINNING_NUMBER_SIZE.getMessage());
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
}
