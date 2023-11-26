package lotto.view.input.validator;

import java.util.Arrays;
import java.util.List;
import lotto.exception.custom.CustomNullPointAmountException;
import lotto.exception.custom.CustomNumberFormatAmountException;
import lotto.exception.winning.WinningExceptionStatus;
import lotto.utils.Delimiter;

public class ReadWinningValidator {

    private static final ReadWinningValidator READ_WINNING_VALIDATOR = new ReadWinningValidator();

    private ReadWinningValidator() {
    }

    public static List<Integer> validateWinning(final String winning) {
        return READ_WINNING_VALIDATOR.parseWinning(winning);
    }

    private List<Integer> parseWinning(final String winning) {
        return Arrays.stream(Delimiter.splitWithComma(winning))
                .map(this::parseNumber)
                .toList();
    }

    private int parseNumber(final String winning) {
        try {
            return Integer.parseInt(isNullWinning(winning));
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatAmountException(WinningExceptionStatus.READ_IS_NOT_NUMERIC);
        }
    }

    private String isNullWinning(final String winning) {
        try {
            return winning.trim();
        } catch (NullPointerException e) {
            throw new CustomNullPointAmountException(WinningExceptionStatus.READ_IS_NULL);
        }
    }
}
