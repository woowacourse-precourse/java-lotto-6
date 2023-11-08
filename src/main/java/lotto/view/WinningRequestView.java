package lotto.view;

import static lotto.view.ui.Input.enterMessage;
import static lotto.view.ui.Output.printlnMessage;
import static lotto.view.ui.Output.printlnMessageWithNewLine;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.WinningNumbers;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class WinningRequestView {
    private static final String WINNING_NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String SEPARATOR = ",";

    public static WinningNumbers request() {
        printlnMessageWithNewLine(WINNING_NUMBERS_REQUEST_MESSAGE);
        try {
            String winningNumbers = Validator.validate(enterMessage());
            return WinningNumbers.from(parseWinningNumbers(winningNumbers));
        } catch (IllegalArgumentException e) {
            printlnMessage(e.getMessage());
            return request();
        }
    }

    private static Lotto parseWinningNumbers(final String winningNumbers) {
        try {
            return Lotto.from(Arrays.stream(split(winningNumbers))
                    .map(Integer::parseInt)
                    .map(Number::valueOf)
                    .toList());
        } catch (NumberFormatException e) {
            throw LottoException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    private static String[] split(final String winningNumbers) {
        return winningNumbers.split(SEPARATOR);
    }

    private static class Validator {
        private static String validate(final String message) {
            validateInvalidSeparators(message);
            return message;
        }

        private static void validateInvalidSeparators(final String message) {
            if (hasEdgeSeparator(message) || hasDuplicatedSeparator(message)) {
                throw LottoException.from(ErrorMessage.INVALID_SEPARATOR_ERROR);
            }
        }

        private static boolean hasEdgeSeparator(final String message) {
            return startsWithSeparator(message) || endsWithSeparator(message);
        }

        private static boolean startsWithSeparator(final String message) {
            return message.startsWith(SEPARATOR);
        }

        private static boolean endsWithSeparator(final String message) {
            return message.endsWith(SEPARATOR);
        }

        private static boolean hasDuplicatedSeparator(final String message) {
            return message.contains(SEPARATOR.repeat(2));
        }
    }
}
