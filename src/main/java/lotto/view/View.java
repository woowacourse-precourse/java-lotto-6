package lotto.view;

import static lotto.global.constants.NumberType.COST_UNIT;
import static lotto.view.constants.MessageType.BONUS_NUMBER_REQUEST_MESSAGE;
import static lotto.view.constants.MessageType.EARNINGS_RATE_MESSAGE;
import static lotto.view.constants.MessageType.LOTTO_COUNT_MESSAGE;
import static lotto.view.constants.MessageType.WINNING_NUMBERS_REQUEST_MESSAGE;
import static lotto.view.constants.MessageType.WINNING_RESULT_INFORMATION;
import static lotto.view.constants.MessageType.WINNING_RESULT_NOTICE;
import static lotto.view.constants.MessageType.WINNING_RESULT_WITH_BONUS_INFORMATION;
import static lotto.view.constants.SymbolType.INPUT_SEPARATOR;
import static lotto.view.constants.SymbolType.OUTPUT_SEPARATOR;
import static lotto.view.constants.SymbolType.POSTFIX;
import static lotto.view.constants.SymbolType.PREFIX;
import static lotto.view.ui.Input.enterMessage;
import static lotto.view.ui.Output.printlnFormat;
import static lotto.view.ui.Output.printlnFormatWithNewLine;
import static lotto.view.ui.Output.printlnMessageWithNewLine;
import static lotto.view.ui.Output.printlnResult;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.domain.WinningType;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;
import lotto.view.constants.MessageType;

public final class View {


    public static void printLottos(Lottos lottos) {
        printLottosCount(lottos.getSize());
        printLottosInfo(lottos.getLottos());
    }

    public static String requestWinningNumbers() {
        printlnMessageWithNewLine(WINNING_NUMBERS_REQUEST_MESSAGE);
        return Validator.validateWinningNumbers(enterMessage());
    }

    public static String requestBonusNumber() {
        printlnMessageWithNewLine(BONUS_NUMBER_REQUEST_MESSAGE);
        return Validator.validateBonusNumber(enterMessage());
    }

    public static void printWinningResult(WinningResult winningResult, int cost) {
        printlnMessageWithNewLine(WINNING_RESULT_NOTICE);

        Arrays.stream(WinningType.values())
                .filter(winningType -> !winningType.equals(WinningType.NONE))
                .forEach(winningType -> printWinningNumbers(winningType, winningResult));

        printlnFormat(EARNINGS_RATE_MESSAGE, winningResult.calculateEarningsRate(cost));
    }

    private static void printWinningNumbers(WinningType winningType, WinningResult winningResult) {
        printlnFormat(getResultInformation(winningType),
                winningType.getWinningCount(),
                winningType.getPrice(),
                winningResult.getValue(winningType));
    }

    private static MessageType getResultInformation(WinningType winningType) {
        if (winningType.hasBonusNumber() == false) {
            return WINNING_RESULT_INFORMATION;
        }
        return WINNING_RESULT_WITH_BONUS_INFORMATION;
    }

    private static void printLottosCount(int count) {
        printlnFormatWithNewLine(LOTTO_COUNT_MESSAGE, count);
    }

    private static void printLottosInfo(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoInfo(lotto);
        }
    }

    private static void printLottoInfo(Lotto lotto) {
        String result = String.join(OUTPUT_SEPARATOR.getSymbol(), convertNumbers(lotto.getNumbers()));
        printlnResult(PREFIX.getSymbol() + result + POSTFIX.getSymbol());
    }

    private static String[] convertNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .map(Object::toString)
                .toArray(String[]::new);
    }


    private static class Validator {
        private static String validateWinningNumbers(String message) {
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

        private static String validateBonusNumber(String message) {
            validateNumber(message);
            return message;
        }
    }
}
