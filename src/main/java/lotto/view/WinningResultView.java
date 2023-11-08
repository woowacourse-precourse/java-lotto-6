package lotto.view;

import static lotto.view.ui.Output.printlnFormat;
import static lotto.view.ui.Output.printlnMessageWithNewLine;

import java.util.Arrays;
import lotto.domain.Cost;
import lotto.domain.WinningResult;
import lotto.domain.WinningType;

public class WinningResultView {
    private static final String NEWLINE = "\n";
    private static final String WINNING_RESULT_NOTICE = "당첨 통계" + NEWLINE + "---";
    private static final String WINNING_RESULT_INFORMATION = "%d개 일치 (%,d원) - %d개";
    private static final String WINNING_RESULT_WITH_BONUS_INFORMATION = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String EARNINGS_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void print(final WinningResult winningResult, final Cost cost) {
        printlnMessageWithNewLine(WINNING_RESULT_NOTICE);

        Arrays.stream(WinningType.values())
                .filter(winningType -> !winningType.equals(WinningType.NONE))
                .forEach(winningType -> printWinningNumbers(winningType, winningResult));

        printlnFormat(EARNINGS_RATE_MESSAGE, winningResult.calculateEarningsRate(cost));
    }

    private static void printWinningNumbers(final WinningType winningType, final WinningResult winningResult) {
        printlnFormat(getResultInformation(winningType),
                winningType.getWinningCount(),
                winningType.getPrice(),
                winningResult.getValue(winningType));
    }

    private static String getResultInformation(final WinningType winningType) {
        if (winningType.hasBonusNumber() == false) {
            return WINNING_RESULT_INFORMATION;
        }
        return WINNING_RESULT_WITH_BONUS_INFORMATION;
    }
}
