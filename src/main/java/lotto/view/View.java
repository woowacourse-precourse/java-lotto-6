package lotto.view;

import static lotto.global.constants.NumberType.COST_UNIT;
import static lotto.view.constants.MessageType.BONUS_NUMBER_REQUEST_MESSAGE;
import static lotto.view.constants.MessageType.COST_REQUEST_MESSAGE;
import static lotto.view.constants.MessageType.EARNINGS_RATE_MESSAGE;
import static lotto.view.constants.MessageType.LOTTO_COUNT_MESSAGE;
import static lotto.view.constants.MessageType.WINNING_NUMBERS_REQUEST_MESSAGE;
import static lotto.view.constants.MessageType.WINNING_RESULT_INFORMATION;
import static lotto.view.constants.MessageType.WINNING_RESULT_NOTICE;
import static lotto.view.constants.MessageType.WINNING_RESULT_WITH_BONUS_INFORMATION;
import static lotto.view.constants.SymbolType.INPUT_SEPARATOR;
import static lotto.view.constants.SymbolType.NEWLINE;
import static lotto.view.constants.SymbolType.OUTPUT_SEPARATOR;
import static lotto.view.constants.SymbolType.POSTFIX;
import static lotto.view.constants.SymbolType.PREFIX;

import camp.nextstep.edu.missionutils.Console;
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
    public static String requestCost() {
        printlnMessage(COST_REQUEST_MESSAGE);
        return Validator.validateCost(enterMessage());
    }

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

    /* Output View */
    private static void printlnResult(String result) {
        System.out.println(result);
    }

    private static void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    private static void printlnMessageWithNewLine(MessageType messageType) {
        System.out.print(NEWLINE.getSymbol());
        printlnMessage(messageType);
    }

    private static void printlnFormat(MessageType message, Object... args) {
        System.out.println(String.format(message.getMessage(), args));
    }

    private static void printlnFormatWithNewLine(MessageType message, Object... args) {
        System.out.print(NEWLINE.getSymbol());
        printlnFormat(message, args);
    }

    /* Input View */
    private static String enterMessage() {
        return Validator.validate(Console.readLine());
    }

    private static class Validator {
        private static String validate(String message) {
            if (isBlank(message)) {
                throw LottoException.from(ErrorMessage.BLANK_INPUT_ERROR);
            }
            return message;
        }

        private static boolean isBlank(String message) {
            return message.isBlank();
        }

        private static String validateCost(String cost) {
            validateNumber(cost);
            validateUnit(cost);
            return cost;
        }

        private static void validateNumber(String message) {
            if (isNotNumber(message)) {
                throw LottoException.from(ErrorMessage.NOT_NUMBER_ERROR);
            }
        }

        private static boolean isNotNumber(String message) {
            return !message.matches("\\d+");
        }

        private static void validateUnit(String cost) {
            if (isNotDivisible(cost)) {
                throw LottoException.from(ErrorMessage.INVALID_UNIT_ERROR);
            }
        }

        private static boolean isNotDivisible(String cost) {
            return Integer.parseInt(cost) % COST_UNIT.getValue() != 0;
        }

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
