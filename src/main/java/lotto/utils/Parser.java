package lotto.utils;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.ErrorMessage.BONUS_NUMBER_NOT_A_NUMBER;
import static lotto.utils.ErrorMessage.WINNING_NUMBERS_NOT_A_NUMBER;

public class Parser {
    private static final String SPLIT_UNIT = ",";

    public static List<Integer> parseWinningNumbers(String winningNumbers) {
        try {
            return Arrays.stream(winningNumbers.split(SPLIT_UNIT))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_A_NUMBER.getDescription());
        }
    }

    public static Integer parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_A_NUMBER.getDescription());
        }
    }
}
