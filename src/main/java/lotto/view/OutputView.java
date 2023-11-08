package lotto.view;

import static java.lang.String.format;
import static lotto.constants.SeparatorConstant.RESULT_SUMMARY_SEPARATOR;
import static lotto.enums.ConsoleMessage.ENTER_BONUS_NUMBER;
import static lotto.enums.ConsoleMessage.ENTER_PURCHASE_AMOUNT;
import static lotto.enums.ConsoleMessage.ENTER_WINNING_NUMBERS;
import static lotto.enums.ConsoleMessage.RESULTS_SUMMARY;
import static lotto.enums.ConsoleMessage.SUCCESS_PURCHASE_LOTTO;
import static lotto.enums.ConsoleMessage.TOTAL_RETURN;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.RankingResult;
import lotto.exception.LottoGameException;

public class OutputView {

    public static void printEnterPurchaseAmount() {
        println(ENTER_PURCHASE_AMOUNT.getMessage());
    }

    public static void printLotteriesInfo(final List<String> lotteries) {
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

    public static void printResultsSummary(final RankingResult rankingResult) {
        printNewLine();
        println(RESULTS_SUMMARY.getMessage());
        println(RESULT_SUMMARY_SEPARATOR);

        for (String message : rankingResult.receiveRankingResultInfo()) {
            println(message);
        }
    }

    public static void printResultsProfitability(final BigDecimal profitability) {
        println(format(TOTAL_RETURN.getMessage(), profitability.toPlainString()));
    }

    public static void printErrorMessage(final LottoGameException exception) {
        System.out.println(exception.getMessage());
    }

    private static void println(final String message) {
        System.out.println(message);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
