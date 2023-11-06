package lotto.view;

import static java.lang.String.format;
import static lotto.view.ConsoleMessage.ENTER_BONUS_NUMBER;
import static lotto.view.ConsoleMessage.ENTER_PURCHASE_AMOUNT;
import static lotto.view.ConsoleMessage.ENTER_WINNING_NUMBERS;
import static lotto.view.ConsoleMessage.RESULTS_SUMMARY;
import static lotto.view.ConsoleMessage.SUCCESS_PURCHASE_LOTTO;
import static lotto.view.ConsoleMessage.TOTAL_RETURN;
import static lotto.domain.constants.SeparatorConstant.RESULT_SUMMARY_SEPARATOR;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.RankingResult;

public class OutputView {

    public static void printEnterPurchaseAmount() {
        println(ENTER_PURCHASE_AMOUNT.getMessage());
    }

    public static void printLotteriesInfo(List<String> lotteries) {
        printNewLine();
        println(format(SUCCESS_PURCHASE_LOTTO.getMessage(), lotteries.size()));
        for (String lottery : lotteries) {
            println(lottery);
        }
        printNewLine();
    }

    public static void printEnterWinningNumbers() {
        printNewLine();
        println(ENTER_WINNING_NUMBERS.getMessage());
    }

    public static void printEnterBonusNumber() {
        printNewLine();
        println(ENTER_BONUS_NUMBER.getMessage());
    }

    public static void printResultsSummary(RankingResult rankingResult) {
        printNewLine();
        println(RESULTS_SUMMARY.getMessage());
        println(RESULT_SUMMARY_SEPARATOR);

        for (String message : rankingResult.receiveRankingResultInfo()) {
            println(message);
        }
    }

    public static void printResultsProfitability(BigDecimal profitability) {
        println(format(TOTAL_RETURN.getMessage(), profitability.toPlainString()));
    }

    public static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    private static void println(final String message) {
        System.out.println(message);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
