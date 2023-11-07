package lotto.validation.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.property.ErrorProperty.*;
import static lotto.property.LottoProperty.DELIMITER;
import static lotto.property.LottoProperty.WINNING_SIZE;

public class WinningValidator extends RootValidator {
    public static void winningsCountIsOverOrUnder(String winningNumbers) {
        if (winningNumbers.split(DELIMITER).length != WINNING_SIZE) {
            throw new IllegalArgumentException(WINNING_COUNT_IS_OVER_OR_UNDER.toString());
        }
    }

    public static void winningsFormatIsCorrect(String winningNumbers) {
        if (!winningNumbers.matches("^(\\d{1,2},)*\\d{1,2}$")) {
            throw new IllegalArgumentException(WINNING_FORMAT_IS_NOT_CORRECT.toString());
        }
    }

    public static void winningsIsDuplicate(String winningNumbers) {
        List<String> winningList = Arrays.asList(winningNumbers.split(DELIMITER));
        if (winningList.size() != new HashSet<>(winningList).size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_IS_DUPLICATE.toString());
        }
    }
}
