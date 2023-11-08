package lotto.view;

import static lotto.view.constants.SymbolType.INPUT_SEPARATOR;
import static lotto.view.ui.Input.enterMessage;
import static lotto.view.ui.Output.printlnMessageWithNewLine;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Number;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class WinningRequestView {
    private static final String WINNING_NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String SEPARATOR = ",";

    public static List<Number> request() {
        printlnMessageWithNewLine(WINNING_NUMBERS_REQUEST_MESSAGE);
        try {
            String winningNumbers = Validator.validate(enterMessage());
            return parseWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            return request();
        }
    }

    private static List<Number> parseWinningNumbers(final String winningNumbers) {
        try {
            return Arrays.stream(split(winningNumbers))
                    .map(Integer::parseInt)
                    .map(Number::valueOf)
                    .toList();
        } catch (NumberFormatException e) {
            throw LottoException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    private static String[] split(final String winningNumbers) {
        return winningNumbers.split(INPUT_SEPARATOR.getSymbol());
    }

    private static class Validator {
        private static String validate(String message) {
            validateInvalidSeparators(message);
            return message;
        }

        private static void validateInvalidSeparators(String message) {
            if (hasEdgeSeparator(message) || hasDuplicatedSeparator(message)) {
                throw LottoException.from(ErrorMessage.INVALID_SEPARATOR_ERROR);
            }
        }

        private static boolean hasEdgeSeparator(String message) {
            return startsWithSeparator(message) || endsWithSeparator(message);
        }

        private static boolean startsWithSeparator(String message) {
            return message.startsWith(INPUT_SEPARATOR.getSymbol());
        }

        private static boolean endsWithSeparator(String message) {
            return message.endsWith(INPUT_SEPARATOR.getSymbol());
        }

        private static boolean hasDuplicatedSeparator(String message) {
            return message.contains(INPUT_SEPARATOR.getSymbol().repeat(2));
        }
    }
}
