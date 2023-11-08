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
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;
import lotto.domain.WinningType;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;
import lotto.view.constants.MessageType;

public final class View {


    public static String requestBonusNumber() {
        printlnMessageWithNewLine(BONUS_NUMBER_REQUEST_MESSAGE);
        return Validator.validateBonusNumber(enterMessage());
    }

    public static void printWinningResult(WinningResult winningResult, Cost cost) {
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


    private static class Validator {


        private static String validateBonusNumber(String message) {
            validateNumber(message);
            return message;
        }
    }
}
