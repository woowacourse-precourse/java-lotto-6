package lotto.validation.validator;

import static lotto.property.ErrorProperty.WINNING_COUNT_IS_OVER_OR_UNDER;
import static lotto.property.ErrorProperty.WINNING_FORMAT_IS_NOT_CORRECT;
import static lotto.property.LottoProperty.DELIMITER;
import static lotto.property.LottoProperty.WINNING_SIZE;

public class WinningValidator extends RootValidator {
    public static void winningsCountIsOverOrUnder(String winningNumbers) {
        if (winningNumbers.split(DELIMITER).length != WINNING_SIZE) {
            throw new IllegalArgumentException(WINNING_COUNT_IS_OVER_OR_UNDER.toString());
        }
    }

    public static void winningsFormatIsCorrect(String winningNumbers) {
        System.out.println("!!=" + winningNumbers);
        if (!winningNumbers.matches("^(\\d{1,2},)*\\d{1,2}$")) {
            throw new IllegalArgumentException(WINNING_FORMAT_IS_NOT_CORRECT.toString());
        }
    }
}
