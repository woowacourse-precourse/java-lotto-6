package lotto.utils;

import lotto.constants.ExceptionMessage;
import lotto.constants.GameRule;
import lotto.domain.WinningNumber;

public class InputValidator {
    public static void validatePayNumber(String pay) {
        checkNumber(pay);
        checkNegativeNumber(pay);
    }

    public static void validateWinningNumber(String input) {
        checkDelimStartOrEnd(input);
        checkConsecutiveDelim(input);
        checkWhitespace(input);

        String[] numbers = input.split(",");
        for (String number : numbers) {
            checkNumber(number);
            checkLottoRange(number);
        }
    }

    public static void validateBonusNumber(String number, WinningNumber winningNumber) {
        checkNumber(number);
        checkNegativeNumber(number);
        checkDuplicateWithWinning(number, winningNumber);
        checkLottoRange(number);
    }

    private static void checkNumber(String number) {
        int intValue = 0;
        try {
            intValue = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw LottoGameException.withMessageAndException(ExceptionMessage.NOT_INTEGER_ERROR, e);
        }
    }

    public static void checkNegativeNumber(String number) {
        if (Integer.parseInt(number) <= 0) {
            throw LottoGameException.withMessage(ExceptionMessage.NEGATIVE_NUMBER_ERROR);
        }
    }

    public static void checkDelimStartOrEnd(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw LottoGameException.withMessage(ExceptionMessage.DELIM_START_END_ERROR);
        }
    }

    public static void checkConsecutiveDelim(String input) {
        if (input.contains(",,")) {
            throw LottoGameException.withMessage(ExceptionMessage.DELIM_CONSECUTIVE_ERROR);
        }
    }

    public static void checkWhitespace(String input) {
        if (input.contains(" ")) {
            throw LottoGameException.withMessage(ExceptionMessage.WHITESPACE_ERROR);
        }
    }

    public static void checkLottoRange(String number) {
        if (Integer.parseInt(number) < GameRule.MIN_LOTTO_NUMBER  || Integer.parseInt(number) > GameRule.MAX_LOTTO_NUMBER) {
            throw LottoGameException.withMessage(ExceptionMessage.LOTTO_RANGE_ERROR);
        }
    }

    public static void checkDuplicateWithWinning(String number, WinningNumber winningNumber) {
        if (winningNumber.contain(Integer.parseInt(number))) {
            throw LottoGameException.withMessage(ExceptionMessage.BONUS_DUPLICATE_ERROR);
        }
    }
}
