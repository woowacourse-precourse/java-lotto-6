package lotto.view;

import static lotto.view.constants.SymbolType.INPUT_SEPARATOR;
import static lotto.view.ui.Input.enterMessage;
import static lotto.view.ui.Output.printlnMessageWithNewLine;

import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class WinningRequestView {
    private static final String WINNING_NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static String request() {
        printlnMessageWithNewLine(WINNING_NUMBERS_REQUEST_MESSAGE);
        try {
            return Validator.validate(enterMessage());
        } catch (IllegalArgumentException e) {
            return Validator.validate(enterMessage());
        }
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
